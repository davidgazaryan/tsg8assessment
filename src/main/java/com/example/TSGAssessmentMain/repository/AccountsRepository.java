package com.example.TSGAssessmentMain.repository;

import com.example.TSGAssessmentMain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountsRepository extends JpaRepository<Account, Long > {
    List<Account> findByCustomer_Id(Long customerId);
}
