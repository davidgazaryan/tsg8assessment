package com.example.tsgassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.example.tsgassessment.repository")
@EntityScan("com.example.tsgassessment.model")
public class TsgAssessmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(TsgAssessmentApplication.class, args);
    }

}











