/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

/*
 *    - Write an application
 *      that asks the user for the principal amount
 *      that asks the user for the rate of interest (as a percent then divide by 100)
 *      that asks the user for number of years
 *      that asks the user for the number of times interest is compounded
 *      calculate how much money will be made with the user input
 *      print out the amount of money made with n years and r interest and t years compounded
 */

package exercise13;
import java.util.*;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution13 {
    private static Scanner in = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("0.00"); // DecimalFormat is to ensure 2 decimal places are always printed out
    public static void main(String[] args){
        Solution13 solution = new Solution13();
        int principal = (int)solution.askForInput("What is the principal amount? ");
        double rateInterest = solution.askForInput("What is the rate? ");
        int years = (int)solution.askForInput("What is the number of years? ");
        int compound = (int)solution.askForInput("What is the number of times the interest is compounded per year? ");
        double interestAmount = solution.calculateInterest(principal, rateInterest, years, compound);
        // Allows the program round to the 2nd decimal place in case there is more than 2 decimal places
        BigDecimal bd = new BigDecimal(interestAmount).setScale(2, RoundingMode.CEILING);
        double roundedInterestAmount = bd.doubleValue();
        solution.printOutput(principal, rateInterest, years, compound, roundedInterestAmount);
    }

    public double askForInput(String question){
        System.out.print(question);
        return in.nextDouble(); // Gets double from user
    }

    public double calculateInterest(int principal, double rate, int years, int compound){
        // A = P(1 + r/n)^(n*t)
        return principal*Math.pow((1 + ((rate/100)/compound)), (compound*years));
    }

    public void printOutput(int principal, double rate, int years, int compound, double interest){
        System.out.println("$" + principal + " invested at " + rate + "% for " + years + " years compounded " + compound + " times per year is $" + df.format(interest) +".");
    }
}
