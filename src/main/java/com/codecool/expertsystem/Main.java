package com.codecool.expertsystem;

import com.codecool.expertsystem.controllers.ESProvider;
import com.codecool.expertsystem.models.FactParser;
import com.codecool.expertsystem.models.RuleParser;

public class Main {

    private static boolean failedLoadingResources = false;

    public static void main(String[] args) {

        FactParser factParser = new FactParser("src/main/resources/oncologistDiagnose.xml");
        RuleParser ruleParser = new RuleParser("src/main/resources/oncologistQuestions.xml");
        if (!failedLoadingResources) {
            ESProvider esProvider = new ESProvider(factParser, ruleParser);
            esProvider.startDiagnose();
        }
    }


    public static void resourcesNotFound() {
        failedLoadingResources = true;
    }
}
