/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

/*
 *    - Write an application
 *      that asks the user for height and weight
 *          *This will continue to ask if the user does not enter
 *            a valid option in this case an int
 *      calculate bmi using (weight/height^2) * 703
 *      print out BMI
 *      if BMI is between 18.5 and 25
 *          print out ideal weight
 *      if BMI is less than 18.5
 *          print out underweight
 *      if BMI is greater than 25
 *          print out overweight
 */

package exercise19;
import java.util.*;

public class Solution19 {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        Solution19 solution = new Solution19();
        int height = solution.askForInput("What is your height in inches? ");
        int weight = solution.askForInput("What is your weight in pounds? ");
        double bMI = solution.calculateBMI(height, weight);
        System.out.println("Your BMI is " + bMI + ".");
        if(bMI < 18.5){
            System.out.println("You are underweight. You should see your doctor.");
        }
        if(bMI >= 18.5 && bMI <= 25){
            System.out.println("You are within the ideal weight range.");
        }
        if(bMI > 25){
            System.out.println("You are overweight. You should see your doctor.");
        }
    }

    public int askForInput(String question){ // Uses catch and InputMismatchException to ensure the right type of input
        int output = 0;
        boolean invalidInput = true;
        do{
            invalidInput = false;
            try{
                do{
                    System.out.print(question);
                    output = in.nextInt();
                }while(output < 0);
            }catch(InputMismatchException e){ // Checks the input to see if it is valid or not
                invalidInput = true;
                in.nextLine();
            }
        }while(invalidInput); // Loop while the input is invalid
        return output;
    }

    public double calculateBMI(int height, int weight){
        return (weight/Math.pow(height, 2))*703;
    }
}
