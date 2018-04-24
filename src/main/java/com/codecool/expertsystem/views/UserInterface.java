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

    public static void showDiagnose(String diagnose) {
        System.out.println("Opinion of our expert: ");
        System.out.println("~~" + diagnose + "~~");
        printSeparator();
    }

    private static void printSeparator() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
