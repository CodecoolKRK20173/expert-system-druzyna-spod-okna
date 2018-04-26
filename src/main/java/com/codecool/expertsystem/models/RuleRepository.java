package com.codecool.expertsystem.models;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/**
 * <h1>RuleRepository class</h1>
 * The RuleRepository allows to form the collection of questions and
 * to operate it by adding, deleting elements and iterate over them.
 * <p>
 * @author pkaminski
 * @version 1.0
 */
public class RuleRepository {

    List<Question> questions = new ArrayList<Question>();

    /**
     * Add Question object to List
     */
    void addQuestion(Question question) {
        questions.add(question);
    }

    List<Question> getQuestions() {
        return this.questions;
    }

    /**
     * @return QuestionIterator
     */
    public Iterator<Question> getIterator() {
        return new QuestionIterator(this);
    }
}
