package com.codecool.expertsystem.models;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class RuleRepository {

    List<Question> questions = new ArrayList<Question>();
    
    void addQuestion(Question question) {
        questions.add(question);
    }

    List<Question> getQuestions() {
        return this.questions;
    }

    public Iterator<Question> getIterator() {
        return new QuestionIterator(this);
    }
}
