package com.example.tsgassessment.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Customer {
    @Id
    private long id;
    private String name;
    private String email;
    private String address;
    private LocalDateTime createdAt;
}
