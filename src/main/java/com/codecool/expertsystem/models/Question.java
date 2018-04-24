package com.codecool.expertsystem.models;

public class Question {

    String id;
    String question;
    Answer answer;

    public Question () {

    }

    public Question(String id, String question, Answer answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public  String getQuestion() {
        return question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public boolean getEvaluatedAnswer(String input) {
        return true;
    }
}
