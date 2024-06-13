package com.example.TSGAssessmentMain.controller;

import com.example.TSGAssessmentMain.model.Account;
import com.example.TSGAssessmentMain.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountsAPI {

    private final AccountsRepository accountsRepository;
    @Autowired
    public AccountsAPI(AccountsRepository accountsRepository){
        this.accountsRepository = accountsRepository;
    }

    @GetMapping
    public ResponseEntity<List<Account>> GetAllAccounts(){
        List<Account> accounts = accountsRepository.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {

        account.setCreatedAt(LocalDateTime.now());

        Account savedAccount = accountsRepository.save(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAccount);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable long id) {
        Optional<Account> optionalAccount = accountsRepository.findById(id);
        return optionalAccount.map(account -> ResponseEntity.ok().body(account))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/customers/{id}/accounts")
    public ResponseEntity<List<Account>> getAccountsByCustomerId(@PathVariable long id) {
        List<Account> accounts = accountsRepository.findByCustomer_Id(id);
        return ResponseEntity.ok().body(accounts);
    }



}
