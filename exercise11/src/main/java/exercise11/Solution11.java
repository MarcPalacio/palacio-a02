/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

/*
 *    - Write an application
 *      that asks the user how many euros they are exchanging
 *      that asks the user for the exchange rate between euros and usd
 *      prints out the two previous inputs in format
 *      calculate euros to usd with conversion rate
 *      print out the converted money in format
 */

package exercise11;
import java.util.*;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution11 {
    private static Scanner in = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("0.00"); // DecimalFormat is to ensure 2 decimal places are always printed out
    public static void main(String[] args){
        Solution11 solution = new Solution11();
        int eurosAmount = (int)solution.askForInput("How many euros are you exchanging? ");
        double exchangeRate = solution.askForInput("What is the exchange rate? ");
        double usdAmount = solution.calculateConversion(eurosAmount, exchangeRate);
        BigDecimal bd = new BigDecimal(usdAmount).setScale(2, RoundingMode.CEILING);
        double roundedUSD = bd.doubleValue();
        solution.printOutput(eurosAmount, exchangeRate, roundedUSD);
    }

    public double askForInput(String question){
        System.out.print(question);
        return in.nextDouble(); // Gets double from user
    }

    public double calculateConversion(int euros, double rate){
        return euros*rate;
    }

    public void printOutput(int euros, double exchangeRate, double roundedUSD){
        System.out.println(euros + " euros at the exchange rate of " + exchangeRate + " is");
        System.out.println(df.format(roundedUSD) + " U.S. dollars."); // To ensure 2 decimal places are printed
    }
}