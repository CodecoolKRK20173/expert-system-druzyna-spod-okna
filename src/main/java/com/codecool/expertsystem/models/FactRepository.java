package com.codecool.expertsystem.models;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class FactRepository {

    private List<Fact> facts = new ArrayList<Fact>();

    void addFact(Fact fact) {
        facts.add(fact);
    }

    List<Fact> getFacts() {
        return facts;
    }

    public Iterator<Fact> getIterator() {
        return new FactIterator(this);
    }
}
