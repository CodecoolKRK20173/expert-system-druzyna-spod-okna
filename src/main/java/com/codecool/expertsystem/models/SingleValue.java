package com.codecool.expertsystem.models;

import java.util.ArrayList;
import java.util.List;

public class SingleValue extends Value {

    String param;
    boolean selectionType;

    public SingleValue(String param, boolean selectionType) {
        this.param = param;
        this.selectionType = selectionType;
    }

    @Override
    public List<String> getInputPattern() {
        ArrayList list = new ArrayList<String>();
        list.add(param);
        return list;
    }
    
    @Override
    public boolean getSelectionType() {
        return selectionType;
    }
}
