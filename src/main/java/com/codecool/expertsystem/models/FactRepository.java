package com.codecool.expertsystem.models;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
* <h1>FactRepository class</h1>
* The FactRepository allows to form the collection of facts and
* to operate it by adding, deleting elements and iterate over them.
* <p>
*
* @author  Dimitros
* @version 1.0
* @since   2018-04-23
*/

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
