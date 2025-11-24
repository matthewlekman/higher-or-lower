package com.game.cli;

import com.game.data.CsvData;
import com.game.game.HigherLowerGame;
import com.game.model.Country;
import com.game.model.Guess;
import java.util.Scanner;


public class GameCli {
    private Scanner scanner;
    private HigherLowerGame game;

    public GameCli() {
        this.scanner = new Scanner(System.in);
    }

    public void start() throws Exception {
        System.out.println("Welcome to Higher or Lower - with a football twist!");
        CsvData csvData = new CsvData("data/countries.csv");
        this.game = new HigherLowerGame(csvData);
        while (!game.isGameOver()) {
            gameLoop();
        }
        System.out.println("\n==== GAME OVER ===");
        showStats();
        scanner.close();
    }

    public void gameLoop() {
        System.out.println("Current country - " + game.getCurrentCountry());
        System.out.println("Higher or Lower?\n");
        String input = scanner.nextLine().toLowerCase();

        Guess guess;
        if (input.equals("h")) {
            guess = Guess.HIGHER;
        } else if (input.equals("l")){
            guess = Guess.LOWER;
        } else {
            System.out.println("Invalid input. Use h or l");
            return;
        }
        Country revealed = game.getNextCountry();
        boolean correct = game.makeGuess(guess);

        if (correct) {
            System.out.println("CORRECT! It was: " + revealed);
        } else {
            System.out.println("WRONG! It was: " + revealed);
        }
        System.out.println("====================");
        showStats();
        System.out.println();
    }

    public void showStats() {
        System.out.println("Accuracy - " + String.format("%.1f%%", game.getGameState().getAccuracy()));
        System.out.println("Correct guesses - " + game.getGameState().getCorrectGuesses());
        System.out.println("Total guesses - " + game.getGameState().getTotalGuesses());
        System.out.println("Longest streak - " + game.getGameState().getLongestStreak());
        System.out.println("Current streak - " + game.getGameState().getCurrentStreak());
    }
}
