package com.codecool.expertsystem.models;

import java.util.Iterator;
import java.util.List;

/**
* <h1>FactIterator class</h1>
* The FactIterator class creates a iterator object to iterate over collections of facts.
* <p>
*
* @author  Dimitros
* @version 1.0
* @since   2018-04-24
*/

public class FactIterator implements Iterator<Fact> {

    private int index;
    private List<Fact> facts;

<<<<<<< HEAD
 /**
   * Constructor creating an Iterator object to iterate over collection of Fact objects.
   * @param factRepository Parameter to add collection of Fact objects to constructor.
   */
=======
    /**
     *
     * @param factRepository - FactRepository
     */
>>>>>>> d2f75a65c0a21f012589fc5d27bc76cd97d94d89
    public FactIterator(FactRepository factRepository) {
        this.index = 0;
        this.facts = factRepository.getFacts();
    }

    @Override
    public boolean hasNext() {
        return index < facts.size();
    }

    @Override
    public Fact next() {
        Fact fact = facts.get(index);
        index++;
        return fact;
        }
    }
