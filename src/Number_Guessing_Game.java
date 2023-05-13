package oasis_infobyte;

import java.util.Random;
import java.util.Scanner;

public class Number_Guessing_Game {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            Random random = new Random();
            int secretNumber = random.nextInt(100) + 1; //Generate a Random Number Between 1 and 100
            int numberGuess = 0;
            int guess = 0;

            System.out.println("WELCOME TO THE NUMBER GUESSING GAME");
            System.out.println("I'M THINKING  OF A NUMBER BETWEEN 1 AND 100. CAN YOU GUESS IT? ");

            while (guess != secretNumber)
            {
                System.out.println("ENTER YOUR GUESS NUMBER: ");
                guess = scanner.nextInt();
                numberGuess++;

                if(guess < secretNumber){
                    System.out.println("THE NUMBER IS TOO LOW. GUESS AGAIN. ");
                }else if (guess > secretNumber){
                    System.out.println("THE NUMBER IS TOO HIGH. GUESS AGAIN. ");
                }else{
                    System.out.println("CONGRATULATION! YOU GUESSED THE NUMBER IN " + numberGuess + " GUESSES.");
                }
            }
            scanner.close();
        }
    }
