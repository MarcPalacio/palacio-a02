/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

/*
 *    - Write an application
 *      that asks the user for the username
 *      that asks the user for the password
 *      if the user password equals stored password
 *          print a welcome
 *      else
 *          print a farewell
 */

package exercise15;
import java.util.*;

public class Solution15 {
    private static Scanner in = new Scanner(System.in);
    private static final String STORED_PASSWORD = "abc$123";
    public static void main(String[] args){
        Solution15 solution = new Solution15();
        String username = solution.askForInput("What is the username? ");
        String password = solution.askForInput("What is the password? ");
        solution.checkNPrint(password);
    }

    public String askForInput(String question){
        System.out.print(question);
        return in.next(); // Gets string from user
    }

    public void checkNPrint(String password){
        if(password.equals(STORED_PASSWORD)){ // Checks if the two strings are equal
            System.out.println("Welcome!");
        }
        else{
            System.out.println("I dont know you.");
        }
    }
}
