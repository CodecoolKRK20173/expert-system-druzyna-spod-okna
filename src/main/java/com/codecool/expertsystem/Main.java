package com.codecool.expertsystem;

import com.codecool.expertsystem.controllers.ESProvider;
import com.codecool.expertsystem.models.FactParser;
import com.codecool.expertsystem.models.RuleParser;

public class Main {

    public static void main(String[] args) {

        FactParser factParser = new FactParser("src/main/resources/oncologistDiagnose.xml");
        RuleParser ruleParser = new RuleParser("src/main/resources/oncologistQuestions.xml");
        new ESProvider(factParser, ruleParser);
    }
}
