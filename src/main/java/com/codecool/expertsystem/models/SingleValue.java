package com.codecool.expertsystem.models;

public class SingleValue extends Value {

    String param;
    boolean selectionType;

    public SingleValue(String param, boolean selectionType) {
        this.param = param;
        this.selectionType = selectionType;
    }


    public boolean getSelectionType() {
        return selectionType;
    }


    public String getParam() {
        return param;
    }
}
