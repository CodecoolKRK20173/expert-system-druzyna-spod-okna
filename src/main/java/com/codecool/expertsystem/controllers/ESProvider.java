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
        collectAnswers();
        String diagnose = evaluate();
        UserInterface.showDiagnose(diagnose);
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
        FactIterator factIterator = new FactIterator(this.factRepository);
        boolean foundMatch = false;
        Fact currentFact = null;
        while (factIterator.hasNext() && !foundMatch) {
            currentFact = factIterator.next();
            foundMatch = validateFact(currentFact);
        }
        return currentFact.getDescription();
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
