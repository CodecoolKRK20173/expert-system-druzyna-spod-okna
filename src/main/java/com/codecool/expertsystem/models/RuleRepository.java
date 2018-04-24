package com.codecool.expertsystem.models;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class RuleRepository {

    List<Question> questions;

    public RuleRepository() {
        this.questions = new ArrayList<Question>();
    }
    
    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return this.questions;
    }

    public Iterator<Question> getIterator() {
        return new QuestionIterator(this);
    }
}
