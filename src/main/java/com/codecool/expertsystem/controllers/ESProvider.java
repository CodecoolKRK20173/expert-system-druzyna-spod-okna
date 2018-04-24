package com.codecool.expertsystem.controllers;

import com.codecool.expertsystem.models.*;
import com.codecool.expertsystem.views.*;

public class ESProvider {

    private FactRepository factRepository;
    private RuleRepository ruleRepository;

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.factRepository = factParser.getFactRepository();
        this.ruleRepository = ruleParser.getRuleRepository();

    }

    public void collectAnswers() {

    }

    public String getAnswerByQuestion(String questionId) {
        return "";
    }

    public String evaluate() {
        return null;
    }
}
