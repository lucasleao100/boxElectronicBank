package com.lucasl.challenge.withdraw.operations;

import com.lucasl.challenge.withdraw.config.AppConfig;
import com.lucasl.challenge.withdraw.service.OperationService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
        assertEquals(expected, result);

        result = operationService.cashWithdrawal("cashWithdrawalOperation", 50, listNotes);
        assertNotEquals(expected, result);
    }

    @Test
    void DivRemTest(){
        OperationService operationService = (OperationService) applicationContext.getBean("operationService");
        ArrayList<Integer> result;
        ArrayList<Integer> expected = new ArrayList<>();

        expected.add(2);
        expected.add(0);
        result = operationService.DivRem(100,50);
        assertEquals(expected, result);

        expected.add(1);
        expected.add(0);
        result = operationService.DivRem(100,50);
        assertNotEquals(expected, result);
    }
}