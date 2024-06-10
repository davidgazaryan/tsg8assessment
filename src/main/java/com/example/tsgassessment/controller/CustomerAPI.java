package com.example.tsgassessment.controller;

import com.example.tsgassessment.model.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/customers")
@RestController
public class CustomerAPI {
    Customer customer;
}
