package com.codecool.expertsystem.models;

import java.util.*;

public class Fact {

    private String id;
    private String description;
    private Map<String, Boolean> evalsMap;

    /**
     *
     * @param id - String, id of Fact parsed from XML file
     * @param description - String, description of Fact parsed from XML file
     */
    public Fact(String id, String description) {
        this.id = id;
        this.description = description;
        this.evalsMap = new TreeMap<>();
    }

    /**
     * Returns Fact id as String. Id is needed to evaluate Fact
     * @return String
     */
    public String getFactId() {
        return this.id;
    }

    /**
     * Returns key set of Fact evaluation map
     * @return Set<String>
     */
    public Set<String> getIdSet() {
        return evalsMap.keySet();
    }

    /**
     * Puts to map by evaluate id of Fact with given boolean evaluate value
     * @param id - String
     * @param value - boolean
     */
    public void setFactValueById(String id, boolean value) {
        this.evalsMap.put(id, value);
    }

    /**
     * Return boolean value of Fact from evaluation map by given id
     * @param id - String
     * @return boolean
     */
    public boolean getValueById(String id) {
        return evalsMap.get(id);
    }

    /**
     * Returns Fact description
     * @return String
     */
    public String getDescription() {
        return this.description;
    }
}
