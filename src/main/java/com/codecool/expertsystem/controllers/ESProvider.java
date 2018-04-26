package com.codecool.expertsystem.controllers;

import com.codecool.expertsystem.models.*;
import com.codecool.expertsystem.views.UserInterface;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ESProvider {

    private FactRepository factRepository;
    private RuleRepository ruleRepository;
    private Map<String, Boolean> mapOfAnswers = new LinkedHashMap<>();

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.factRepository = factParser.getFactRepository();
        this.ruleRepository = ruleParser.getRuleRepository();
        collectAnswers();
        String diagnose = evaluate();
        UserInterface.showDiagnose(diagnose);
    }

    private void collectAnswers() {
        QuestionIterator questionIterator = new QuestionIterator(this.ruleRepository);
        while (questionIterator.hasNext()) {
            Question nextQuestion = questionIterator.next();
            String answer = getAnswerByQuestion(nextQuestion);
            boolean answerAsBoolean = nextQuestion.getAnswer().evaluateAnswerByInput(answer);
            String answerId = nextQuestion.getId();
            mapOfAnswers.put(answerId, answerAsBoolean);
        }
    }

    private String getAnswerByQuestion(Question questionObj) {
        UserInterface.askQuestion(questionObj.getQuestion());
        return UserInterface.getAnswer();
    }

    private String evaluate() {
        Iterator factIterator = this.factRepository.getIterator();
        boolean foundMatch = false;
        Fact currentFact = null;
        while (factIterator.hasNext() && !foundMatch) {
            currentFact = (Fact) factIterator.next();
            foundMatch = validateFact(currentFact);
        }
        String result = currentFact.getDescription();
        if (result == null) {
            return "Error occurred!";
        }
        return result;
    }

    private boolean validateFact(Fact fact) {
        for (String key : mapOfAnswers.keySet()) {
            if (mapOfAnswers.get(key) != fact.getValueById(key)) {
                return false;
            }
        }
        return true;
    }
}
