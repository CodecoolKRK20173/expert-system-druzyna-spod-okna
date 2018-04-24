package com.codecool.expertsystem.models;

import java.util.ArrayList;

public class Answer {
    ArrayList<Value> values = new ArrayList<Values>();

    public boolean evaluateByInput(String input) {
        
        return true;
    }

    public void addValue(Value value) {
        values.add(value);
    }
    
    public ArrayList<Value> getValues() {
        return values;
    }
}
