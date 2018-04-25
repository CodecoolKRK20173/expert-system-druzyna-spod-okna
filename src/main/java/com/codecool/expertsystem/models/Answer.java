package com.codecool.expertsystem.models;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;

public class Answer {
    List<Value> values;
    List<String> splittedInputList;
    Integer[] rate = new Integer[values.size()];

    public boolean evaluateAnswerByInput(String input) {
        fillArrayWithZeros();
        splittedInputList = splitString(input);
        setAnswerRates();
        if (!hasMatch()) {
            throw new InputMismatchException();
        }     
        return values.get(getIndexOfMaxElement()).getSelectionType();
    }

    public void addValue(Value value) {

    }

    private List<String> splitString(String input) {
        return Arrays.asList(input.split(","));
    }

    private void fillArrayWithZeros() {
        for(int i=0; i<rate.length; i++) {
            rate[i] = 0;
        }
    }

    private void setAnswerRates() {
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
}
