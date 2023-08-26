/**
@Nikunj Gupta
The Driver class is responsible for modeling a popular word guessing game Wordle.
It prompts the user to enter a 5-letter word to guess the chosen word and provides feedback based on each guess.
The game loop continues until the user either guesses the word correctly or runs out of attempts.
*/

import java.util.*;

public class Driver {
    public static void main(String[] args) {
        // Create a new game instance
        Game theGame = new Game();

        // Initialize variables for keeping track of game state and user input
        String keepOn = "";
        boolean keepPlaying = true;
        Scanner in = new Scanner(System.in);

        // Welcome message to the user
        System.out.println("Welcome to Fruiter - the fruit based word game! Enter a 5 letter word to guess what today's word is");

        // Game loop
        while (keepPlaying) {
            // Get the current state of the game and display it to the user
            String output = theGame.display();
            System.out.println(output);

            // If the user guessed the word correctly, display a congratulations message and ask if they want to play again
            if (theGame.checkWin()) {
                System.out.println("Congratulations, you won!");
                System.out.println("Would you like to play again? Enter true for yes, false for no.");

                // Get the user's input and determine if they want to keep playing or exit the game
                keepOn = in.next();
                if (!keepOn.equals("true")) {
                    keepPlaying = false;
                } else {
                    theGame = new Game();
                }
            }
            // If the user ran out of attempts, display a message with the correct word and ask if they want to play again
            else if (theGame.getAttemptCounter() >= 6) {
                System.out.println("Sorry, you ran out of attempts. The word was " + theGame.getChosenWord());
                System.out.println("Would you like to play again? Enter true for yes, false for no.");

                // Get the user's input and determine if they want to keep playing or exit the game
                keepOn = in.next();
                if (!keepOn.equals("true")) {
                    keepPlaying = false;
                } else {
                    theGame = new Game();
                }
            }
            // If the game is still ongoing, prompt the user to enter their guess and update the game state with their input
            else {
                System.out.println("Enter your guess:");
                theGame.setUserWord(in.next().toLowerCase());
            }
        }
    }
}
