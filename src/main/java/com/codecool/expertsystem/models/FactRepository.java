package com.codecool.expertsystem.models;

import java.util.*;

public class FactRepository {

    private List<Fact> facts = new ArrayList<>();

    /**
     * Adds Fact to facts list
     * @param fact - Fact
     */
    public void addFact(Fact fact) {
        facts.add(fact);
    }

    /**
     * Return list of all Facts added to this repository
     * @return List<Fact>
     */
    public List<Fact> getFacts() {
        return facts;
    }

    /**
     * Constructs and return FactIterator
     * @return FactIterator
     */
    public Iterator<Fact> getIterator() {
        return new FactIterator(this);
    }
}
