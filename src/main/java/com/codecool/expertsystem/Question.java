package com.codecool.expertsystem;

public class Question {

    String id;
    String question;
    Answer answer;

    public Question(String id, String question, Answer answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public String getId() {
        return null;
    }

    public  String getQuestion() {
        return null;
    }

    public Answer getAnswer() {
        return null;
    }

    public boolean getEvaluatedAnswer(String input) {
        return true;
    }
}