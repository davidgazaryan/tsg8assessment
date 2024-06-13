package com.example.TSGAssessmentMain.repository;

import com.example.TSGAssessmentMain.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
    List<Transactions> findByAccountId(Long AccountId);
}
