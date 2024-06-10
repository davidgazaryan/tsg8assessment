package com.example.tsgassessment.controller;

import com.example.tsgassessment.model.Account;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AccountsAPI {
    Account account;
}
