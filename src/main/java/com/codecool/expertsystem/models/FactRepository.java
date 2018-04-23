package com.codecool.expertsystem.models;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class FactRepository {

    private List<Fact> factList;

    public FactRepository() {
        this.factList = new ArrayList<>();
    }


    public void addFact(Fact fact) {
        this.factList.add(fact);
    }


    public Iterator<Fact> getIterator() {
        return null;
    }
}
