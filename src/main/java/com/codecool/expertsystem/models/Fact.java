package com.codecool.expertsystem.models;

import java.util.Set;
import java.util.Map;
import java.util.TreeMap;

public class Fact {

    String id;
    String description;
    Map<String, Boolean> evalsMap;

    public Fact(String id, String description) {
        this.id = id;
        this.description = description;
        this.evalsMap = new TreeMap<>();
    }


    public String getFactId() {
        return this.id;
    }


    public Set<String> getIdSet() {
        return evalsMap.keySet();
    }


    public void setFactValueById(String id, boolean value) {
        this.evalsMap.put(id, value);
    }


    public boolean getValueById(String id) {
        return evalsMap.get(id);
    }


    public String getDescription() {
        return this.description;
    }
}
