/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

/*
 *    - Write an application
 *      that asks the user a series of questions that will
 *      troubleshoot their car
 *      Example:
 *      if car is slient when you turn the keys
 *      if yes
 *          print another question
 *      if no
 *          output solution
 */

package exercise23;
import java.util.*;

public class Solution23 {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        Solution23 solution = new Solution23();
        solution.firstCheck(solution.askForInput("Is the car silent when you turn the key? "));
    }

    public String askForInput(String question) {
        System.out.print(question);
        return in.next(); // Gets integer from user
    }

    public void lastCheck(String input){ // Last set of conditions to check
        if(input.equals("y")){
            input = askForInput("Does the car have fuel injection? ");
            if(input.equals("y")){
                System.out.println("Get it in for service.");
                input = "s";
            }
            else if(input.equals("n")) {
                System.out.println("Check to ensure the choke is opening and closing.");
                input = "s";
            }
        }
        else if(input.equals("n")) {
            System.out.println("This should not be possible.");
        }
    }

    public void secondLastCheck(String input){ // 4th set of conditions to check
        if(input.equals("y")){
            System.out.println("Check spark plug connections.");
            input = "s";
        }
        else if(input.equals("n")){
            lastCheck(askForInput("Does the engine start and then die? "));
        }
    }

    public void thirdLastCheck(String input){ // Checkes these condition (3rd one)
        if(input.equals("y")){
            System.out.println("Replace the battery.");
            input = "s";
        }
        else if(input.equals("n")){
            secondLastCheck(askForInput("Does the car crank up but fail to start? "));
        }
    }

    public void secondCheck(String input){ // Checks these conditions next afterwards
        if(input.equals("y")) {
            System.out.println("Clean terminals and try starting again.");
            input = "s";
        }
        else if(input.equals("n")) {
            System.out.println("Replace cables and try again.");
            input = "s";
        }
    }

    public void firstCheck(String input){ // Checks these conditions first
        if(input.equals("y")){
            secondCheck(askForInput("Are the battery terminals corroded? "));
        }
        else if(input.equals("n")){
            thirdLastCheck(askForInput("Does the car make a slicking noise? "));
        }
    }
}
