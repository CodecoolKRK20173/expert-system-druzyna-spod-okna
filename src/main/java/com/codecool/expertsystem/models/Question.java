package com.codecool.expertsystem.models;

/**
* <h1>Question class</h1>
* The Question class creates a question object and operates its parameters
* using getters.
* <p>
*
* @author  Dimitros
* @version 1.0
* @since   2018-04-24
*/

public class Question {

    private String id;
    private String question;
    private Answer answer;

    /**
   * Constructor creating a question object based on three parameters.
   * @param id First parameter distinguishes each question 
   * to let it be later evaluated against certain fact
   * @param question  Second parameter contains string representation of a question
   * @param answer Third parameter is an object of Answer class
   */
    public Question(String id, String question, Answer answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    /**
   * Getter of question's id.
   * @return String Returns id of a question object.
   */
    public String getId() {
        return id;
    }

    /**
   * Getter of question.
   * @return String Returns string representation of a question object.
   */
    public  String getQuestion() {
        return question;
    }

    /**
   * Getter of answer.
   * @return Answer Returns a question object's answer(as object).
   */
    public Answer getAnswer() {
        return answer;
    }

    /**
   * Method to check the result of answer evaluation.
   * @return  boolean Returns boolean representation of users answer.
   */
    public boolean getEvaluatedAnswer(String input) {
        return answer.evaluateAnswerByInput(input);

    }
}
