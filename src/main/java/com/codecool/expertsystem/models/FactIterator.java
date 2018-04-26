package com.codecool.expertsystem.models;

import java.util.Iterator;
import java.util.List;

public class FactIterator implements Iterator<Fact> {

    private int index;
    private List<Fact> facts;

    /**
     *
     * @param factRepository - FactRepository
     */
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
