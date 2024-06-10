package com.example.tsgassessment.model;

import javax.persistence.*;
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

}
