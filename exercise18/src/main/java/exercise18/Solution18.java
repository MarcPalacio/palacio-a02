/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

/*
 *    - Write an application
 *      that asks the user if they want to convert Celsius or Fahrenheit
 *      if the user wants Celsius
 *          ask the temperature in Fahrenheit
 *          convert the temp to Celsius and print it out
 *      if the user wants Fahrenheit
 *          ask the temperature in Celsius
 *          convert the temp to Fahrenheit and print it out
 */

package exercise18;
import java.util.*;

public class Solution18 {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Solution18 solution = new Solution18();
        String fahOrCel = solution.askForInput("Press C to convert from Fahrenheit to Celsius.\nPress F to convert from Celsius to Fahrenheit.\nYour choice: ");
        double temperature = solution.askForTemperature(fahOrCel);
        double convertedTemp = solution.calcTemp(fahOrCel, temperature);
        solution.printOutput(fahOrCel, convertedTemp);
    }

    public String askForInput(String question){
        System.out.print(question);
        return in.next(); // Gets string from user
    }

    public double askForTemperature(String choice){
        double output = 0;
        if(choice.equals("C") || choice.equals("c")){
            output = Double.parseDouble(askForInput("Please enter the temperature in Fahrenheit: "));
        }
        else if(choice.equals("F") || choice.equals("f")){
            output = Double.parseDouble(askForInput("Please enter the temperature in Celsius: "));
        }
        return output;
    }

    public double calcTemp(String choice, double temp){
        if(choice.equals("C") || choice.equals("c")){ // Uses Celsius formula
            return (temp-32)*5/9;
        }
        else if(choice.equals("F") || choice.equals("f")){ // Uses Fahrenheit formula
            return (temp*9/5)+32;
        }
        return 0;
    }

    public void printOutput(String choice, double temp){
        if(choice.equals("C") || choice.equals("c")){
            System.out.println("The temperature in Celsius is " + temp + ".");
        }
        else if(choice.equals("F") || choice.equals("f")){
            System.out.println("The temperature in Fahrenheit is " + temp + ".");
        }
    }
}
