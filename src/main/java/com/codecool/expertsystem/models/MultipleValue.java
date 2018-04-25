package com.codecool.expertsystem.models;

import java.util.List;

public class MultipleValue extends Value {

    List<String> param;
    boolean selectionType;

    public MultipleValue(List<String> param, boolean selectionType) {
        this.param = param;
        this.selectionType = selectionType;
    }

    @Override
    public List<String> getInputPattern() {
        return param;
    }

    @Override
    public boolean getSelectionType() {
        return selectionType;
    }
}
