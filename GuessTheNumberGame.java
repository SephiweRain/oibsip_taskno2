import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

    // Main method to play the game
    public static void playGame() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int maxRounds = 3;
        int maxAttempts = 5;

        System.out.println("Welcome to the Guess the Number Game!");

        for (int round = 1; round <= maxRounds; round++) {
            int targetNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + round + ": Guess the number between 1 and 100");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score += (maxAttempts - attempts + 1) * 10; // Higher score for fewer attempts
                    guessedCorrectly = true;
                } else if (userGuess < targetNumber) {
                    System.out.println("The number is higher than your guess. Try again.");
                } else {
                    System.out.println("The number is lower than your guess. Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The number was " + targetNumber);
            }
        }

        System.out.println("\nGame over! Your final score is: " + score);
        scanner.close();
    }

    public static void main(String[] args) {
        playGame();
    }
}

