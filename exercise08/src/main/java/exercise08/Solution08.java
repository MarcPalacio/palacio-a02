/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

/*
 *    - Write an application
 *      that asks the user for the number of people
 *      that asks the user for the number of pizzas
 *      that asks the user for the number of slices per pizza
 *      calculate and output total slices, how many slices everyone gets, the number of left over slices
 */

package exercise08;
import java.util.*;

public class Solution08 {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        Solution08 solution = new Solution08();
        // Asks the user for input
        int numPeople = solution.askForInput("How many people? ");
        int numPizza = solution.askForInput("How many pizzas do you have? ");
        int numSlices = solution.askForInput("How many slices per pizza? ");
        solution.calcNPrintOutput(numPeople, numPizza, numSlices);
    }

    public int askForInput(String question){
        System.out.print(question);
        return in.nextInt();
    }

    public void calcNPrintOutput(int numPeople, int numPizza, int numSlices){
        // Calculates the values needed for the output
        int numTotalSlices = numSlices*numPizza;
        int slicePPerson = numTotalSlices/numPeople;
        int remainderSlices = numTotalSlices%numPeople;
        // Prints out the output with the necessary values
        System.out.println(numPeople + " people with " + numPizza + " pizzas (" + numTotalSlices + " slices)");
        System.out.println("Each person gets " + slicePPerson + " pieces of pizza.");
        System.out.println("There are " + remainderSlices + " leftover pieces.");
    }
}
