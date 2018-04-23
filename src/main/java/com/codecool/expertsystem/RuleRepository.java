package com.codecool.expertsystem;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class RuleRepository {

    List<Question> questions = new ArrayList<>();
    
    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return this.questions;
    }

    public Iterator<Question> getIterator() {
        return null;
    }
}