/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

/*
 *    - Write an application
 *      that asks the user for the principal amount
 *      that asks the user for the rate of interest (as a percent then divide by 100)
 *      that asks the user for number of years
 *      calculate how much money will be made in n years with r interest
 *      print out the amount of money made with n years and r interest
 */

package exercise12;
import java.util.*;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution12 {
    private static Scanner in = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("0.00"); // DecimalFormat is to ensure 2 decimal places are always printed out
    public static void main(String[] args){
        Solution12 solution = new Solution12();
        int principal = (int)solution.askForInput("Enter the principal: ");
        double rateInterest = solution.askForInput("Enter the rate of interest: ");
        int years = (int)solution.askForInput("Enter the number of years: ");
        double interestAmount = solution.calculateInterest(principal, rateInterest, years);
        // Allows the program round to the 2nd decimal place in case there is more than 2 decimal places
        BigDecimal bd = new BigDecimal(interestAmount).setScale(2, RoundingMode.CEILING);
        double roundedInterestAmount = bd.doubleValue();
        solution.printOutput(years, rateInterest, roundedInterestAmount);
    }

    public double askForInput(String question){
        System.out.print(question);
        return in.nextDouble(); // Gets double from user
    }

    public double calculateInterest(int principal, double rate, int years){
        return principal*(1 + (rate/100)*years);
    }

    public void printOutput(int years, double rate, double interest){
        System.out.println("After " + years + " years at " + rate + "%, the investment will be worth $" + df.format(interest) + ".");
    }
}
