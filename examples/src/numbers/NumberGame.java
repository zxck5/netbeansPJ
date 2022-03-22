package numbers;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random generator = new Random();
        
        boolean play = true;
               
        while (play) {
            int correct = generator.nextInt(21);
            System.out.println("Please enter your guess");

            int guess = scanner.nextInt();
            int numberTries = 1;

            // loop until user's input is equal to the correct number
            while (guess != correct) {
                if (guess > correct) {
                    System.out.println("Your guess is too high");
                } else  {
                    System.out.println("Your guess is too low");
                } 
                guess = scanner.nextInt();
                numberTries++;
            }

            System.out.println("Correct! You got it in " + numberTries + ". Would you like to play again?");
            if (scanner.next().equals("no")) {
                // terminate the game
                play = false;
                System.out.println("Thank you for playing. Goodbye!");
            }
        }
    }   
} 
