package com.codecool.expertsystem.models;

import java.util.List;
import java.util.ArrayList;


public abstract class Value {

    public List<String> getInputPattern() {
        if (this instanceof SingleValue) {
            List<String> inputPattern = new ArrayList<>();
            inputPattern.add(((SingleValue) this).getParam());
            return inputPattern;
        } else {
            return ((MultipleValue) this).getParam();
        }
    }

    public boolean getSelectionType() {
        if (this instanceof SingleValue)
            return ((SingleValue) this).getSelectionType();
        else
            return ((MultipleValue) this).getSelectionType();
    }
}
