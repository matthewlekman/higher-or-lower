package com.game.game;

import com.game.data.CountryData;
import com.game.model.Country;
import com.game.model.GameState;
import com.game.model.Guess;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HigherLowerGame {
    private GameState gameState;
    private Country nextCountry;

    public HigherLowerGame(CountryData dataSource) throws Exception{
        List<Country> allCountries = dataSource.loadCountries();
        Collections.shuffle(allCountries);
        List<Country> deck = new ArrayList<>(allCountries.subList(0,52));
        this.gameState = new GameState(deck);
        Country firstCard = this.gameState.drawNextCountry();
        gameState.setCurrentCountry(firstCard);
        this.nextCountry = gameState.drawNextCountry();
    }

    public boolean makeGuess(Guess guess) {
        Country current = gameState.getCurrentCountry();
        boolean correct;

        if (guess == Guess.HIGHER) {
            correct = (nextCountry.getRanking() < current.getRanking());
        } else {
            correct = (nextCountry.getRanking() > current.getRanking());
        }
        gameState.recordGuess(correct);
        gameState.setCurrentCountry(this.nextCountry);
        this.nextCountry = gameState.drawNextCountry();

        return correct;
    }

    public Country getCurrentCountry() {return gameState.getCurrentCountry();}
    public Country getNextCountry() {return nextCountry;}
    public GameState getGameState() {return gameState;}

    public boolean isGameOver() {
        return !gameState.hasMoreCountries();
    }
}
