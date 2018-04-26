package com.codecool.expertsystem.models;

import java.util.*;

/**
* <h1>Answer class</h1>
* The Answer class operates answers given by an user
* and standard answers from the database to compare them.
* <p>
*
* @author  Dimitros
* @version 1.0
* @since   2018-04-25
*/

public class Answer {
    private List<Value> values = new ArrayList<>();
    private Integer[] rate;

    /**
   * Main method of class which takes user input, using 
   * other methods of class, processes it and gives boolean 
   * represenatinon of passed answer.
   * @param input  Paramenter contains information given by user.
   * @return boolean Returns boolean representation of answer matched
   * with user input.
   */
    public boolean evaluateAnswerByInput(String input) {
        calculateAnswerRates(input);
        if (!hasMatch()) {
            throw new InputMismatchException();
        }     
        return values.get(getIndexOfMaxElement()).getSelectionType();
    }

    /**
   * Method to add every value object to list.
   * @param Value This is an object of Value class contains collection
   * of values (string and boolean) of every standard answer.
   */
    public void addValue(Value value) {
        values.add(value);
    }

    /**
   * Method to split user input string into elements of a list.
   * @return List<String> list of answers.
   */
    private List<String> splitString(String input) {
        return Arrays.asList(input.split(","));
    }

    /**
   * Method checks appearance of user's answers in lists of standard
   * answers and increments the correspondent position in
   * array by one to find the list with more matches.
   * @param String Paramenter contains information given by user.
   */
    private void calculateAnswerRates(String input) {
        this.rate = new Integer[values.size()];
        Arrays.fill(rate, 0);
        for (String elem : splitString(input)) {
            for (int i=0; i<values.size(); i++) {
                if (values.get(i).getInputPattern().contains(elem.toLowerCase())) {
                    rate[i] += 1; 
                }
            }
        }
    }
    
    /**
   * Method searches for max element with value and returns 
   * its index.
   * @param int index of max element in array.
   */
    private int getIndexOfMaxElement() {
        Integer max = Collections.max(Arrays.asList(rate));
        int index = Arrays.asList(rate).indexOf(max);

        return index;
    }

    /**
   * Method checks for elements non equal to 0.
   * @return boolean result of search is true if element
   * non equal to 0 has been found.
   */
    public boolean hasMatch() {
        for (int i=0; i<rate.length; i++) {
            if (rate[i] != 0)
            return true;
        }
        return false;
    }

    /**
   * Getter of Value objects.
   * @return List<Value> list of Value objects.
   */
    public List<Value> getValues() {
        return values;
    }
}
