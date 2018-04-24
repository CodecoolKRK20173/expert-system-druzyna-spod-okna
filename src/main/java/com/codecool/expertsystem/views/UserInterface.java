package com.codecool.expertsystem.views;

public class UserInterface {

    public static void askQuestion(String question) {
        printSeparator();
        System.out.println(question);
    }

    public static String getAnswer() {
        System.out.print("Your answer: ");
        return UserInput.getString();
    }

    private static void printSeparator() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
