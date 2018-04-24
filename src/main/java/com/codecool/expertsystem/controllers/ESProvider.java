package com.codecool.expertsystem.controllers;

import com.codecool.expertsystem.models.*;
import com.codecool.expertsystem.views.UserInterface;

import java.util.LinkedHashMap;
import java.util.Map;

public class ESProvider {

    private FactRepository factRepository;
    private RuleRepository ruleRepository;
    private Map<String, Boolean> mapOfAnswers = new LinkedHashMap<>();

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.factRepository = factParser.getFactRepository();
        this.ruleRepository = ruleParser.getRuleRepository();
    }

    public void collectAnswers() {
        QuestionIterator questionIterator = new QuestionIterator(this.ruleRepository);
        while (questionIterator.hasNext()) {
            Question nextQuestion = questionIterator.next();
            String answer = getAnswerByQuestion(nextQuestion);
            boolean answerAsBoolean = nextQuestion.getAnswer().evaluateByInput(answer);
            String answerId = nextQuestion.getId();
            mapOfAnswers.put(answerId, answerAsBoolean);
        }
    }

    public String getAnswerByQuestion(Question questionObj) {
        UserInterface.askQuestion(questionObj.getQuestion());
        return UserInterface.getAnswer();
    }

    public String evaluate() {
        return null;
    }
}
