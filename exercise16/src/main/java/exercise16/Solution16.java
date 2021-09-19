/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

/*
 *    - Write an application
 *      that asks the user for their age
 *      if their age is 16 or over
 *          print out that they can drive legally
 *      else
 *          print out that they can't drive legally
 */

package exercise16;
import java.util.*;

public class Solution16 {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Solution16 solution = new Solution16();
        int age = solution.askForInput("What is your age? ");
        System.out.println((age >= 16)?"You are old enough to legally drive.":"You are not old enough to legally drive.");
    }

    public int askForInput(String question){
        System.out.print(question);
        return in.nextInt(); // Gets string from user
    }
}