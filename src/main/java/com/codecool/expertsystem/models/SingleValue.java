package com.codecool.expertsystem.models;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>SingleValue</h1>
 * stores acceptable answers
 * @author pkaminski
 * @version 1.0
 */
public class SingleValue extends Value {

    private String param;
    private boolean selectionType;

    /**
     * Constructor
     *  sets fields with given parameters
     *  @param param acceptable answer
     *  @param selectionType 
     */
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
