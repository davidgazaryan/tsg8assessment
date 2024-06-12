package com.example.TSGAssessmentMain.controller;

import com.example.TSGAssessmentMain.model.Transactions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class TransactionsAPI {
    Transactions transactions;
}
