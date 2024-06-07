package com.example.tsgassessment.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "address", nullable = false, unique = true)
    private String address;
    private LocalDateTime createdAt;
}
