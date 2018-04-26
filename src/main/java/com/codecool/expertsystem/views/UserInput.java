package com.codecool.expertsystem.views;

import java.util.Scanner;

public class UserInput {

    /**
     * Method used to get input from user winth Scanner object
     * @return User input as single string
     */
    public static String getString() {
        Scanner userInput = new Scanner(System.in);
        return userInput.next();
    }

}
