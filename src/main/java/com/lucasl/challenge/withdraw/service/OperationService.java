package com.lucasl.challenge.withdraw.service;

import com.lucasl.challenge.withdraw.command.OperationCommand;
import com.lucasl.challenge.withdraw.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;

public class OperationService {

    public OperationService(){}

    public ArrayList<HashMap> cashWithdrawal(String searchBean, double value, int [] listNotes){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        OperationCommand operation = (OperationCommand) applicationContext.getBean(searchBean, value, listNotes);
        applicationContext.close();

        return operation.execute();
    }

    public ArrayList<Integer> DivRem(double dividend, int divisor){
        int quocient = (int) (dividend / divisor);
        int remainder = (int) (dividend % divisor);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(quocient);
        result.add(remainder);

        return result;
    }
}

