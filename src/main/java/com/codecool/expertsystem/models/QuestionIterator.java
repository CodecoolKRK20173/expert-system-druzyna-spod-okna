package com.codecool.expertsystem.models;

import java.util.Iterator;
import java.util.List;

/**
* <h1>RuleIterator class</h1>
* The RuleIterator class creates a iterator object to iterate over collections of questions.
* <p>
*
* @author  Dimitros
* @version 1.0
* @since   2018-04-24
*/

public class QuestionIterator implements Iterator<Question> {

    private int index;
    private List<Question> questions;

    /**
   * Constructor creating an Iterator object to iterate over collection of Question objects.
   * @param factRepository Parameter to add collection of Question objects to constructor.
   */
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
