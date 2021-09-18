/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

/*
 *    - Write an application
 *      that asks the user for the length of the ceiling
 *      that asks the user for the width of the ceiling
 *      calculate how many gallons of paint is needed to cover the ceiling (1 gallon = 350 square feet)
 *      output how many gallons is needed
 */

package exercise09;
import java.util.*;

public class Solution09 {
    private static Scanner in = new Scanner(System.in);
    private static final int CONVERSION_RATE = 350;
    public static void main(String[] args){
        Solution09 solution = new Solution09();
        int length = solution.askForInput("What is the length of the ceiling? ");
        int width = solution.askForInput("What is the width of the ceiling? ");
        solution.calcNOutput(length, width);
    }

    public int askForInput(String question){
        System.out.print(question);
        return in.nextInt();
    }

    public void calcNOutput(int length, int width){
        int numGallons = (int)Math.ceil(length*width/(double)CONVERSION_RATE); // Casted one variable to a double to round up with Math.ceil
        int area = length*width;
        System.out.println("You will need to purchase " + numGallons + " gallons of paint to cover " + area + " sqaure feet.");
    }
}
