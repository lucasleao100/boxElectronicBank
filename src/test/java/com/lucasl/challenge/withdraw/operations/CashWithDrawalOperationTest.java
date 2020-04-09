package com.lucasl.challenge.withdraw.operations;

import com.lucasl.challenge.withdraw.Service.OperationService;
import com.lucasl.challenge.withdraw.config.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;

class CashWithDrawalOperationTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void executeTestWithdraw(){
        ArrayList<HashMap> expected = new ArrayList<>();
        HashMap<Integer, Integer> noteMap1 = new HashMap<>();
        HashMap<Integer, Integer> noteMap2 = new HashMap<>();
        HashMap<Integer, Integer> noteMap3 = new HashMap<>();
        HashMap<Integer, Integer> noteMap4 = new HashMap<>();

        noteMap1.put(1, 100);
        noteMap2.put(2, 50);
        noteMap3.put(5, 20);
        noteMap4.put(10, 10);

        expected.add(noteMap1);
        expected.add(noteMap2);
        expected.add(noteMap3);
        expected.add(noteMap4);

        OperationService operationService = (OperationService) applicationContext.getBean("operationService");
        ArrayList<HashMap> result;
        int[] listNotes = {100, 50, 20, 10};
        result = operationService.cashWithdrawal("cashWithdrawalOperation", 100, listNotes);
        Assertions.assertEquals(expected, result);
    }
}