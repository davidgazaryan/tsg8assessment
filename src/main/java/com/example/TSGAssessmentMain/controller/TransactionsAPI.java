package com.example.TSGAssessmentMain.controller;

import com.example.TSGAssessmentMain.model.Account;
import com.example.TSGAssessmentMain.model.Transactions;
import com.example.TSGAssessmentMain.repository.AccountsRepository;
import com.example.TSGAssessmentMain.repository.TransactionsRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts/{accountId}/transactions")
public class TransactionsAPI {

    private final AccountsRepository accountsRepository;
    private final TransactionsRepository transactionsRepository;


    public TransactionsAPI(AccountsRepository accountsRepository, TransactionsRepository transactionsRepository) {
        this.accountsRepository = accountsRepository;
        this.transactionsRepository = transactionsRepository;
    }

    @Operation(summary = "Get all transactions for a specific account")
    @GetMapping
    public ResponseEntity<List<Transactions>> getTransactions(@PathVariable Long accountId) {
        Optional<Account> optionalAccount = accountsRepository.findById(accountId);
        if (optionalAccount.isPresent()) {
            List<Transactions> transactions = transactionsRepository.findByAccountId(accountId);
            return ResponseEntity.ok(transactions);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiResponse(responseCode = "200", description = "Successfully deposited money")
    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@PathVariable Long accountId, @RequestParam BigDecimal amount) {
        Optional<Account> optionalAccount = accountsRepository.findById(accountId);
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            return ResponseEntity.badRequest().body("Deposit amount must be non-negative");
        }
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setBalance(account.getBalance().add(amount));

            Transactions transactions = new Transactions();
            transactions.setAccount(account);
            transactions.setAccountType(account.getAccountType());
            transactions.setAmount(amount);
            transactions.setTimestamp(LocalDateTime.now());

            accountsRepository.save(account);
            transactionsRepository.save(transactions);

            return ResponseEntity.ok("Deposit successful");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiResponse(responseCode = "200", description = "Successfully withdrew money")
    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@PathVariable Long accountId, @RequestParam BigDecimal amount) {
        Optional<Account> optionalAccount = accountsRepository.findById(accountId);
        if (amount.compareTo(BigDecimal.ZERO) < 0){
            return ResponseEntity.badRequest().body("Withdraw amount can not be below 0");
        }
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            BigDecimal newBalance = account.getBalance().subtract(amount);
            if (newBalance.compareTo(BigDecimal.ZERO) >= 0) {
                account.setBalance(newBalance);

                Transactions transactions = new Transactions();
                transactions.setAccount(account);
                transactions.setAccountType(account.getAccountType());
                transactions.setAmount(amount.negate()); // Withdrawal amount is negative
                transactions.setTimestamp(LocalDateTime.now());

                accountsRepository.save(account);
                transactionsRepository.save(transactions);

                return ResponseEntity.ok("Withdrawal successful");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient funds");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    }



