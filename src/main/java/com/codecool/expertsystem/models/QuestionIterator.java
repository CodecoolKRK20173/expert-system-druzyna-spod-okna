package com.codecool.expertsystem.models;

import java.util.Iterator;
import java.util.List;

public class QuestionIterator implements Iterator<Question> {

    private int index;
    private List<Question> questions;


    public QuestionIterator(RuleRepository ruleRepository) {
        this.index = 0;
        this.questions = ruleRepository.getQuestions();
    }

    @Override
    public boolean hasNext() {
        return index < questions.size();
    }

    @Override
    public Question next() {
        Question entry = questions.get(index);
        index++;
        return entry;
        }
    }
