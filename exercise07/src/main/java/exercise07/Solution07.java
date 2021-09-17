/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

/*
 *    - Write an application
 *      that asks the user for the length of the room in feet
 *      that asks the user for the width of the room in feet
 *      prints out what the user inputted
 *      calculate and print area in square feet and square meters
 */

package exercise07;
import java.util.*;

public class Solution07 {
    // Initialization of variables
    private static Scanner in = new Scanner(System.in);
    private static final double CONVERSION_RATE = 0.09290304;

    public static void main(String[] args){
        Solution07 solution = new Solution07();
        // Asks user for length of room in feet
        int length = solution.askForInput("What is the length of the room in feet? ");
        int width = solution.askForInput("What is the width of the room in feet? ");
        solution.printDimensions(length, width); // Prints out dimensions
        int area = solution.calculateFtArea(length, width); // Calculates area in square feet
        double sqaMArea = solution.calculateSquMArea(area, CONVERSION_RATE); // Calculates area in square meters
        solution.printOutput(area, sqaMArea); // Prints area in square feet and square meters
    }

    public int askForInput(String question){
        System.out.print(question);
        return in.nextInt();
    }

    public int calculateFtArea(int length, int width){
        return length*width;
    }

    public double calculateSquMArea(int area, double conversion){
        return (double)area*conversion;
    }

    public void printDimensions(int length, int width){
        System.out.println("You entered the dimensions of " + length + " feet by " + width + " feet.");
    }

    public void printOutput(int area, double sqaMArea){
        System.out.println("The area is");
        System.out.println(area + " square feet");
        System.out.printf("%.3f square meters", sqaMArea); // Assuming 3 decimal cases from example output
    }
}
