package com.codecool.expertsystem.controllers;

import com.codecool.expertsystem.models.*;
import com.codecool.expertsystem.views.UserInterface;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ESProvider {

    private FactRepository factRepository;
    private RuleRepository ruleRepository;
    private Map<String, Boolean> mapOfAnswers = new LinkedHashMap<>();

    /**
     * Constructor for ESProvider
     * @param factParser Object used for parsing XML file containing Fact's object data
     * @param ruleParser Object used for parsing XML file containing Question's object data
     */
    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.factRepository = factParser.getFactRepository();
        this.ruleRepository = ruleParser.getRuleRepository();
    }

    /**
     * Handle ESProvider behaviour
     */
    public void startDiagnose() {
        collectAnswers();
        String diagnose = evaluate();
        UserInterface.showDiagnose(diagnose);
    }

    /**
     * Method used for creating mapOfAnswers (LinkedHashMap)
     */
    private void collectAnswers() {
        QuestionIterator questionIterator = (QuestionIterator) ruleRepository.getIterator();
        while (questionIterator.hasNext()) {
            Question question = questionIterator.next();
            boolean answerAsBoolean = getValidAnswerAsBoolean(question);
            String answerId = question.getId();
            mapOfAnswers.put(answerId, answerAsBoolean);
        }
    }

    /**
     * Method asks user for input until he gives correct one
     * then returns it as boolean
     * @param question Object used for storing question (string) and possible answers
     * @return user input as boolean
     */
    private boolean getValidAnswerAsBoolean(Question question) {
        boolean exceptionOccurred;
        boolean isAnswerValid = false;
        String answer;
        do {
            answer = getAnswerByQuestion(question);
            exceptionOccurred = false;
            try {
                isAnswerValid = question.getEvaluatedAnswer(answer);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                exceptionOccurred = true;
            }
        } while (exceptionOccurred);
        return isAnswerValid;
    }

    /**
     * Method prints to user question (String) from Question object
     * then returns user answer
     * @param questionObj Object used for storing question (string)
     * @return user input as string
     */
    private String getAnswerByQuestion(Question questionObj) {
        UserInterface.askQuestion(questionObj.getQuestion());
        return UserInterface.getAnswer();
    }

    /**
     * Method compares user answers with possible facts
     * @return description of matching fact
     */
    private String evaluate() {
        Iterator factIterator = this.factRepository.getIterator();
        boolean foundMatch = false;
        Fact currentFact = null;
        while (factIterator.hasNext() && !foundMatch) {
            currentFact = (Fact) factIterator.next();
            foundMatch = validateFact(currentFact);
        }
        if (foundMatch)
            return getDescriptionOfFact(currentFact);
        return "Unknown disease";
    }

    /**
     * Method gets desciption of given fact,
     * and prevents NullPointerException
     * @param fact object containing description
     * @return description of given fact
     */
    private String getDescriptionOfFact(Fact fact) {
        String result = fact.getDescription();
        if (result == null) {
            return "Error occurred!";
        }
        return result;
    }

    /**
     * Method checks if user answers match given fact
     * @param fact object to compare user answers with
     * @return if given fact matches
     */
    private boolean validateFact(Fact fact) {
        for (String key : mapOfAnswers.keySet()) {
            if (mapOfAnswers.get(key) != fact.getValueById(key)) {
                return false;
            }
        }
        return true;
    }
}
