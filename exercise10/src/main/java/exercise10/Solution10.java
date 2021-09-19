/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

/*
 *    - Write an application
 *      that asks the user for the price of an item
 *      that asks the user for the quantity of items
 *      repeat 2 more times for a total of 3 items
 *      calculate the subtotal for the items
 *      calculate the tax using the rate of 5.5%
 *      print the subtotal, how much tax is, and the total amount
 */

package exercise10;
import java.util.*;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution10 {
    private static Scanner in = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("0.00"); // DecimalFormat is to ensure 2 decimal places are always printed out
    private static final double TAX_RATE = 0.055; // Tax rate of 5.5%
    public static void main(String[] args){
        Solution10 solution = new Solution10();
        double item1Price = solution.askForInput("Enter the price of item 1: ");
        double item1Quantity = solution.askForInput("Enter the quantity of item 1: ");
        double item2Price = solution.askForInput("Enter the price of item 2: ");
        double item2Quantity = solution.askForInput("Enter the quantity of item 2: ");
        double item3Price = solution.askForInput("Enter the price of item 3: ");
        double item3Quantity = solution.askForInput("Enter the quantity of item 3: ");
        double subtotal = solution.calcSubtotal(item1Price, item1Quantity, item2Price, item2Quantity, item3Price, item3Quantity);
        double taxTotal = solution.calcTaxTotal(subtotal);
        double totalCost = solution.calcTotalCost(subtotal, taxTotal);
        // This ensures that if there is more than 2 decimal places, it will always round up so you don't have a 1/10th of a penny
        BigDecimal bd = new BigDecimal(totalCost).setScale(2, RoundingMode.CEILING);
        double roundedTotal = bd.doubleValue();
        solution.printOutput(subtotal, taxTotal, roundedTotal);
    }

    public double askForInput(String question){
        System.out.print(question);
        return Double.parseDouble(in.next()); // Gets string from user, then parses it to a double
    }

    public double calcSubtotal(double item1Price, double item1Quantity, double item2Price, double item2Quantity, double item3Price, double item3Quantity){
        return item1Price*item1Quantity + item2Price*item2Quantity + item3Price*item3Quantity;
    }

    public double calcTaxTotal(double subtotal){
        return subtotal*TAX_RATE;
    }

    public double calcTotalCost(double subtotal, double tax){
        return subtotal+tax;
    }

    public void printOutput(double subtotal, double tax, double total){
        System.out.println("Subtotal: $" + df.format(subtotal));
        System.out.println("Tax: $" + df.format(tax));
        System.out.println("Total: $" + df.format(total));
    }
}