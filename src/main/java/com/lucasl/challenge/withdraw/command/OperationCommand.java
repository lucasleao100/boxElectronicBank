package com.lucasl.challenge.withdraw.command;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class OperationCommand {
    private double value;
    private int [] listNotes;

    public OperationCommand(double value, int [] listNotes){
        this.value = value;
        this.listNotes = listNotes;
    }

    public abstract ArrayList<HashMap> execute();

    public double getValue() {
        return value;
    }

    public int[] getListNotes() {
        return listNotes;
    }
}
