/*  Simple Scanner class to return an integer or String
 * 
 */
package com.anthonyaragon.finalproject;

import java.util.Scanner;

public class GetInput {

	@SuppressWarnings("resource")
    public static String ReadInputString(){
        // declare a new Scanner object
        Scanner scan = new Scanner(System.in);

        // read in user input and store it in the scanned variable
        String scanned = scan.nextLine();

        // return the String result to wherever the "GetInput.ReadInputString()" is called
        return scanned;
    }

    @SuppressWarnings("resource")
    public static int ReadInputInt(){
        // declare a new Scanner object
        Scanner scan = new Scanner(System.in);

        // read in user input and store it in the scanned variable
        int scanned = scan.nextInt();

        // return the int result to wherever the "GetInput.ReadInputInt()" is called
        return scanned;
    }
    

}
