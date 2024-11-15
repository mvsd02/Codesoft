import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {

        Random numberGenerated = new Random();
        int correctGuess = numberGenerated.nextInt(16);  // Generates a number between 0 and 15
        int numberTried = 0;
        int numberGuessed;
        int maxAttempts = 10; // Maximum number of attempts

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String user = scanner.nextLine();

        // Validation to prompt user to input their name before starting the game.
        while (user.length() == 0) {
            System.out.println("Please enter your name:");
            user = scanner.nextLine();
        }

        System.out.println("Hello " + user + "! Welcome to the guessing game."); // Welcome message

        // Game loop with max attempts
        for (int i = 1; i <= maxAttempts; i++) {
            System.out.println("Guess a number between 0 and 15:");

            // Read the user's guess
            numberGuessed = scanner.nextInt();
            numberTried++;

            // Check if the guessed number is correct
            if (numberGuessed == correctGuess) {
                System.out.println("Congratulations " + user + "! You have successfully guessed the correct number in " + numberTried + " attempt(s).");
                break;
            } else if (numberGuessed < correctGuess) {
                System.out.println("Your guess is too low.");
            } else {
                System.out.println("Your guess is too high.");
            }

            // Check if the user has used all the attempts and end the game if true
            if (i == maxAttempts) {
                System.out.println("Sorry, " + user + ", you didn't guess the number in " + maxAttempts + " attempts. The correct number was " + correctGuess + ".");
            }
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}