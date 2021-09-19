/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

/*
 *    - Write an application
 *      that asks the user for 3 numbers
 *      if the 3 numbers are the same
 *          end the program
 *      else
 *          calculate which of the 3 numbers are the largest
 */

package exercise22;
import java.util.*;

public class Solution22 {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Solution22 solution = new Solution22();
        int[] inputs = new int[3];
        inputs[0] = solution.askForInput("Enter the first number: ");
        inputs[1] = solution.askForInput("Enter the second number: ");
        inputs[2] = solution.askForInput("Enter the third number: ");
        if(inputs[0] == inputs[1] || inputs[1] == inputs[2] || inputs[0] == inputs[2]) // Checks if any of the values are the same
            System.out.println("Some of the numbers you inputted are the same. Exiting program.");
        else
            System.out.println("The largest number is " + solution.largeNumber(inputs) + ".");
    }

    public int askForInput(String question) {
        System.out.print(question);
        return in.nextInt(); // Gets integer from user
    }

    public int largeNumber(int[] arr){
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }
}