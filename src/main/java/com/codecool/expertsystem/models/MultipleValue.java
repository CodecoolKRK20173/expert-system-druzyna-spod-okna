package com.codecool.expertsystem.models;

import java.util.List;

/**
 * <h1>MultipleValue</h1>
 * stores acceptable answers
 * @author pkaminski
 * @version 1.0
 */
public class MultipleValue extends Value {

    List<String> param;
    boolean selectionType;

    /**
     * Constructor
     * sets fields with given parameters
     * @param param List of acceptable answers
     * @param selectionType 
     */
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
