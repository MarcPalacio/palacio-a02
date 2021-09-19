/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

/*
 *    - Write an application
 *      that asks the user for the order amount (1 order = $1)
 *      that asks the user for the state
 *      if the state is WI
 *          display subtotal
 *          display tax (WI tax = 5.5% tax)
 *          calculate total and print it out
 *      if the state is not WI
 *          display the total
 */

package exercise14;
import java.util.*;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution14 {
    private static Scanner in = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("0.00"); // DecimalFormat is to ensure 2 decimal places are always printed out
    private static final double WI_TAX_RATE = 0.055;
    public static void main(String[] args) {
        Solution14 solution = new Solution14();
        int orderAmount = Integer.parseInt(solution.askForInput("What is the order amount? "));
        String state = solution.askForInput("What is the state? ");
        double tax = solution.calcTax(orderAmount);
        BigDecimal bd = new BigDecimal(tax).setScale(3, RoundingMode.CEILING);
        double roundedTax = bd.doubleValue();
        double total = solution.calculateTotal(orderAmount, roundedTax, state);
        solution.printOutput(orderAmount, roundedTax, total, state);
    }

    public String askForInput(String question){
        System.out.print(question);
        return in.next(); // Gets string from user
    }

    public double calcTax(int orderAmount){
        return orderAmount*WI_TAX_RATE;
    }

    public double calculateTotal(int order, double tax, String state){
        if(state.equals("WI")){ // Checks if the state was WI
            return order+tax;
        }
        return order;
    }

    public void printOutput(int order, double tax, double total, String state){
        if(state.equals("WI")){ // Checks if the state was WI
            System.out.println("The subtotal is $" + df.format(order) + ".");
            System.out.println("The tax is $" + df.format(tax) + ".");
            df.setRoundingMode(RoundingMode.DOWN); // Since it was already rounded above, this can be set down
            System.out.println("The total is $" + df.format(total) + ".");
        }
        if(!(state.equals("WI")))
            System.out.println("The total is $" + df.format(total) + ".");
    }
}
