package com.example.tsgassessment.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
public class Account {
    @Id
    private long id;
    private BigDecimal balance;
    private AccountType  accountType;

    private LocalDateTime createdAt;

}
