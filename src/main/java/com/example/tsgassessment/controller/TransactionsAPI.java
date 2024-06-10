package com.example.tsgassessment.controller;

import com.example.tsgassessment.model.Transactions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class TransactionsAPI {
    Transactions transactions;
}
