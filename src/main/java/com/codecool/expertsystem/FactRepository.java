package com.codecool.expertsystem;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class FactRepository {

    List<Fact> facts = new ArrayList<>();

    public List<Fact> getFacts() {
        return this.facts;
    }
    
    public void addFact(Fact fact) {

    }

    public Iterator<Fact> getIterator() {
        return null;
    }
}