/**
@Nikunj Gupta
The Game class implements the logic for the Wordle game. It has methods for setting up the game,
choosing a random word, checking if the user has won the game, setting the user's word, checking
if the game is over, and displaying the game board.
*/

import java.util.*;

public class Game {

    // initiate the words array with the words for your variant of wordle, this is the word bank
    private String[] words = { "apple", "grape", "mango", "peach", "melon", "lemon" };
    private String[] attempts;
    private int attemptCounter = -1;
    private String chosenWord = "";
    private String userWord = "";
    private boolean gameOver;

    // set up the game
    public Game() {
        // set up a new game
        gameOver = false;
        attempts = new String[6];
        // set the attempts to blanks to initialize
        for (int i = 0; i < attempts.length; i++) {
            attempts[i] = "";
        }
        setChosenWord();
    }

    // choose a random word from the set
    public String todaysWord() {
        Random rand = new Random();
        int index = rand.nextInt(words.length);
        return words[index];
    }

    // check if the user has won the game
    public boolean checkWin() {
        return userWord.equals(getChosenWord());
    }

    // set the chosen word
    public void setChosenWord() {
        chosenWord = todaysWord();
    }

    // set the user's word
    public void setUserWord(String w) {
        attempts[attemptCounter] = w;
        userWord = w;
    }

    // check if the game is over
    public boolean getGameOver() {
        return gameOver;
    }

    // Display the game board
    public String display() {
        String returnMe = "";

        // Display the word with placeholders for unknown letters
        for (int i = 0; i < chosenWord.length(); i++) {
            char c = chosenWord.charAt(i);
            if (userWord.length() > i && userWord.charAt(i) == c) {
                returnMe += c;
            } else {
                returnMe += "_";
            }
        }

        // Display feedback for each letter in the guess
        for (int i = 0; i < userWord.length(); i++) {
            char c = userWord.charAt(i);
            if (chosenWord.indexOf(c) == -1) {
                returnMe += " -";
            } else if (chosenWord.indexOf(c) == i) {
                returnMe += " +";
            } else {
                returnMe += " ^";
            }
        }

        // Increment the attempt counter
        attemptCounter++;

        // If the user has used all attempts, set game over to true
        if (attemptCounter == attempts.length - 1) {
            gameOver = true;
        }

        return returnMe;
    }

    public String getChosenWord() {
        return chosenWord;
    }

    public void setChosenWord(String chosenWord) {
        this.chosenWord = chosenWord;
    }

    // get the attempt counter
    public int getAttemptCounter() {
        return attemptCounter;
    }

}
