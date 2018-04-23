package com.codecool.expertsystem.models;

import java.util.List;

public class MultipleValue extends Value {

    List<String> param;
    boolean selectionType;

    public MultipleValue(List<String> param, boolean selectionType) {
        this.param = param;
        this.selectionType = selectionType;
    }
}
