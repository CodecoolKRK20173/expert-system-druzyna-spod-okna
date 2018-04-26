package com.codecool.expertsystem.views;

public class UserInterface {

    /**
     * Method used to print question(String)
     * @param question to ask
     */
    public static void askQuestion(String question) {
        printSeparator();
        System.out.print("Question: ");
        System.out.println(question);
    }

    /**
     * Ask user for input, get it and return it
     * @return User input as String
     */
    public static String getAnswer() {
        System.out.print("Your answer: ");
        return UserInput.getString();
    }

    /**
     * Show result of expert system evaluation
     * @param diagnose
     */
    public static void showDiagnose(String diagnose) {
        System.out.println("Opinion of our expert: ");
        System.out.println("~~" + diagnose + "~~");
        printSeparator();
    }

    private static void printSeparator() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
