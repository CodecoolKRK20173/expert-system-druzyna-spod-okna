package com.codecool.expertsystem.views;

import java.util.Scanner;

public class UserInput {

    public static String getString() {
        Scanner userInput = new Scanner(System.in);
        return userInput.next();
    }

}
