package com.codecool.expertsystem.models;

import java.util.*;

public class Answer {
    private List<Value> values = new ArrayList<>();
    private List<String> splittedInputList;
    private Integer[] rate;

    public boolean evaluateAnswerByInput(String input) {
        splittedInputList = splitString(input);
        setAnswerRates();
        if (!hasMatch()) {
            throw new InputMismatchException();
        }     
        return values.get(getIndexOfMaxElement()).getSelectionType();
    }

    public void addValue(Value value) {
        values.add(value);
    }

    private List<String> splitString(String input) {
        return Arrays.asList(input.split(","));
    }

    private void setAnswerRates() {
        this.rate = new Integer[values.size()];
        Arrays.fill(rate, 0);
        for (String elem : splittedInputList) {
            for (int i=0; i<values.size(); i++) {
                if (values.get(i).getInputPattern().contains(elem)) {
                    rate[i] += 1; 
                }
            }
        }
    }
    
    private int getIndexOfMaxElement() {
        Integer max = Collections.max(Arrays.asList(rate));
        int index = Arrays.asList(rate).indexOf(max);

        return index;
    }

    public boolean hasMatch() {
        for (int i=0; i<rate.length; i++) {
            if (rate[i] != 0)
            return true;
        }
        return false;
    }

    public List<Value> getValues() {
        return values;
    }
}
