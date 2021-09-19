/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

/*
 *    - Write an application
 *      that asks the user for a number
 *      if that number corresponds with a month
 *          print out that month
 *      else
 *          give the user an error
 */

package exercise21;
import java.util.*;

public class Solution21 {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Solution21 solution = new Solution21();
        int month = solution.askForInput("Please enter the number of the month: ");
        solution.figureMonth(month);
    }

    public int askForInput(String question){
        System.out.print(question);
        return in.nextInt(); // Gets string from user
    }

    public void figureMonth(int month){
        switch(month){
            case 1:
                System.out.println("The name of the month is January.");
                break;
            case 2:
                System.out.println("The name of the month is February.");
                break;
            case 3:
                System.out.println("The name of the month is March.");
                break;
            case 4:
                System.out.println("The name of the month is April.");
                break;
            case 5:
                System.out.println("The name of the month is May.");
                break;
            case 6:
                System.out.println("The name of the month is June.");
                break;
            case 7:
                System.out.println("The name of the month is July.");
                break;
            case 8:
                System.out.println("The name of the month is August.");
                break;
            case 9:
                System.out.println("The name of the month is September.");
                break;
            case 10:
                System.out.println("The name of the month is October.");
                break;
            case 11:
                System.out.println("The name of the month is November.");
                break;
            case 12:
                System.out.println("The name of the month is December.");
                break;
            default:
                System.out.println("Error. You put in an invalid month.");
                break;
        }
    }
}
