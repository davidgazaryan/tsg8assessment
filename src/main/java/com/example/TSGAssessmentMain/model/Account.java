package com.example.TSGAssessmentMain.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "balance", nullable = false)
    private BigDecimal balance;
    @Column(name = "accountType" , nullable = false)
    private AccountType  accountType;

    private LocalDateTime createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @Transient
    private Long customerId; // Hold the customer_id temporarily

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getter and setter for 'balance' field
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    // Getter and setter for 'accountType' field
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    // Getter and setter for 'createdAt' field
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Getter and setter for 'customer' field
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
