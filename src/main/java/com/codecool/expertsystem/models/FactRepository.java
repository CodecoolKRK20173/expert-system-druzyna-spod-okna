package com.codecool.expertsystem.models;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

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
