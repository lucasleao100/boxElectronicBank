package com.lucasl.challenge.withdraw.operations;

import com.lucasl.challenge.withdraw.command.OperationCommand;
import com.lucasl.challenge.withdraw.config.AppConfig;
import com.lucasl.challenge.withdraw.service.OperationService;
import io.reactivex.Observable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CashWithDrawalOperation extends OperationCommand {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    public CashWithDrawalOperation(double value, int [] listNotes){
        super(value, listNotes);
    }

    @Override
    public ArrayList<HashMap> execute() {
        OperationService service = (OperationService) applicationContext.getBean("operationService");
        ArrayList<HashMap> listNotesMap = new ArrayList<>();
        IntStream listNotes =  Arrays.stream(getListNotes());

        listNotes.forEach(res -> {
            HashMap<Integer, Integer> notesMap = new HashMap<>();
            ArrayList<Integer> result;
            result = service.DivRem(getValue(), res);
            notesMap.put(result.get(0), res);
            listNotesMap.add(notesMap);
        });

        return listNotesMap;
    }
}
