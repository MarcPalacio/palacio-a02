/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

/*
 *    - Write an application
 *      that asks the user for their age
 *      that asks the user when they want to retire
 *      calculate how many years it will take
 *      output when they can retire
 */

package exercise06;
import java.util.*;

public class Solution06 {
    private static Scanner in = new Scanner(System.in);
    private static Date date = new Date();
    public static void main(String[] args){
        Solution06 solution = new Solution06();
        int year = date.getYear();
        int curYear = year + 1900; // Have to add 1900 to get current year
        int curAge = solution.askForInput("What is your current age? ");
        int retAge = solution.askForInput("At what age would you like to retire? ");
        solution.calcNOutput(curYear, curAge, retAge);
    }

    public int askForInput(String question){
        System.out.print(question);
        int output = in.nextInt();
        return output;
    }

    public void calcNOutput(int curYear, int curAge, int retAge){
        System.out.println("You have " + (retAge-curAge) + " years left until you can retire.");
        System.out.println("It's " + curYear + ", so you can retire in " + (curYear+retAge-curAge));
    }
}