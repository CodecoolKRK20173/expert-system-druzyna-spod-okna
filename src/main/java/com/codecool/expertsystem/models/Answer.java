package com.codecool.expertsystem.models;

import java.util.List;
import java.util.Arrays;

public class Answer {
    List<Value> values;
    List<String> splittedInputList;

    public boolean evaluateByInput(String input) {
        splittedInputList = splitString(input);

        return true;
    }

    public void addValue(Value value) {

    }

    private List<String> splitString(String input) {
        return Arrays.asList(input.split(","));
        }



}
