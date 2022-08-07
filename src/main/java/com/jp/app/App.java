package com.jp.app;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        AssessmentMessage message = new AssessmentMessage(-4, "jp.com");
        message.setDateOfBirth(LocalDate.now().minusDays(1));
        AssessmentValidator validator = new AssessmentValidator();
        if(!validator.validate(message)){
            System.out.println("Program failed!");
        }
    }
}
