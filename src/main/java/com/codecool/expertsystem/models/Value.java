package com.codecool.expertsystem.models;

import java.util.List;
import java.util.ArrayList;


/**
 * <h1>Value</h1>
 * @author pkaminski
 * @version 1.0
 */
public abstract class Value {

    abstract public List<String> getInputPattern();

    abstract public boolean getSelectionType();
}
