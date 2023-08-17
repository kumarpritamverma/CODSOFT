package Random;

import java.util.Random;

import java.util.Scanner;


public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minNum = 1;
        int maxNum = 100;
        int attempts = 5;
        int rounds = 0;
        int score = 0;

        do {
            rounds++;
            int targetNumber = random.nextInt(maxNum - minNum + 1) + minNum;
            System.out.println("\nRound " + rounds + " - Guess the number between " + minNum + " and " + maxNum + ".");
            
            for (int attempt = 1; attempt <= attempts; attempt++) {
                int userGuess = getUserGuess(scanner);
                String result = compareGuess(targetNumber, userGuess);

                if (result.equals("correct")) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempt + " attempt(s)!");
                    score += (attempts - attempt + 1);
                    break;
                } else {
                    System.out.println("Your guess is " + result + ". Attempts left: " + (attempts - attempt));
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }

        } while (true);

        System.out.println("\nGame Over! You played " + rounds + " round(s) and your final score is " + score + ".");
        scanner.close();
    }

    public static int getUserGuess(Scanner scanner) {
        System.out.print("Enter your guess: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String compareGuess(int target, int guess) {
        if (guess == target) {
            return "correct";
        } else if (guess < target) {
            return "too low";
        } else {
            return "too high";
        }
    }
}
