/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

/*
 *    - Write an application
 *      that asks the user for the order amount (1 order = $1)
 *      that asks the user for the state
 *      if the state is Wisconsin
 *          ask user for the county
 *          if county is Eau Claire
 *              tax rate is 5.5%
 *          else if county is Dunn
 *              tax rate is 5.4%
 *          else
 *              tax rate is 5%
 *      else if state is Illinois
 *          tax rate is 8%
 *      else
 *          tax rate is 0
 *      calculate tax amount and print out total cost
 */

package exercise20;
import java.util.*;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution20 {
    private static Scanner in = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("0.00"); // DecimalFormat is to ensure 2 decimal places are always printed out
    private static final double WI_TAX_RATE = 0.05;
    private static final double WI_ECC_RATE = 0.005;
    private static final double WI_DC_RATE = 0.004;
    private static final double IL_TAX_RATE = 0.08;
    public static void main(String[] args) {
        Solution20 solution = new Solution20();
        String county = "";
        int orderAmount = Integer.parseInt(solution.askForInput("What is the order amount? "));
        String state = solution.askForInput("What state do you live in? ");
        if(state.equals("Wisconsin")){
            county = solution.askForInput("What county do you live in? ");
        }
        double tax = solution.calcTax(orderAmount, state, county);
        BigDecimal bd = new BigDecimal(tax).setScale(3, RoundingMode.CEILING);
        double roundedTax = bd.doubleValue();
        double total = solution.calculateTotal(orderAmount, roundedTax);
        solution.printOutput(roundedTax, total);
    }

    public String askForInput(String question){
        System.out.print(question);
        return in.nextLine(); // Gets string from user
    }

    public double calcTax(int orderAmount, String state, String county){
        if(state.equals("Wisconsin")){
            if(county.equals("Eau Claire")){ //Checks for the counties in Wisconsin
                double taxRate = WI_TAX_RATE+WI_ECC_RATE;
                return taxRate*orderAmount;
            }
            else if(county.equals("Dunn")){
                double taxRate = WI_TAX_RATE+WI_DC_RATE;
                return taxRate*orderAmount;
            }
            else{ // If it's not Dunn or Eau Claire, it will just be the flat Wisconsin tax rate
                return WI_TAX_RATE*orderAmount;
            }
        }
        else if(state.equals("Illinois")){
            return IL_TAX_RATE*orderAmount;
        }
        return 0; // Returns nothing as a tax rate of 0 since other states dont get charged
    }

    public double calculateTotal(int order, double tax){
        return order+tax;
    }

    public void printOutput(double tax, double total){
            System.out.println("The tax is $" + df.format(tax) + ".");
            df.setRoundingMode(RoundingMode.DOWN); // Since it was already rounded above, this can be set down
            System.out.println("The total is $" + df.format(total) + ".");
    }
}
