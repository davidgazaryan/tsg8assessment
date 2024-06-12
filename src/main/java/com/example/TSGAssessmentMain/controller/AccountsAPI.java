package com.example.TSGAssessmentMain.controller;

import com.example.TSGAssessmentMain.model.Account;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountsAPI {
    Account account;
}
