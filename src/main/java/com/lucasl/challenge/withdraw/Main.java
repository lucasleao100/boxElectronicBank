package com.lucasl.challenge.withdraw;

import com.lucasl.challenge.withdraw.Service.OperationService;
import com.lucasl.challenge.withdraw.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<HashMap> result;
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        OperationService  operationService = (OperationService) applicationContext.getBean("operationService");
        int[] listNotes = {100, 50, 20, 10};
        result = operationService.cashWithdrawal("cashWithdrawalOperation", 100, listNotes);
        System.out.println(result);
    }
}
