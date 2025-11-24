package com.game.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameState {
    private List<Country> deck;
    private Country currentCountry;
    private int correctGuesses;
    private int totalGuesses;
    private int currentStreak;
    private int longestStreak;

    public GameState(List<Country> countries) {
        this.deck = new ArrayList<>(countries);
        Collections.shuffle(this.deck);

        this.correctGuesses = 0;
        this.totalGuesses = 0;
        this.currentStreak = 0;
        this.longestStreak = 0;
    }

    public Country getCurrentCountry() {return this.currentCountry;};
    public int getCorrectGuesses() {return this.correctGuesses;};
    public int getTotalGuesses() {return this.totalGuesses;};
    public int getCurrentStreak() {return this.currentStreak;};
    public int getLongestStreak() {return this.longestStreak;};

    public Country drawNextCountry() {
        if (!this.deck.isEmpty()) {
            return this.deck.remove(0);
        }
        return null;
    }

    public void recordGuess(boolean correct) {
        if (correct) {
            this.correctGuesses++;
            this.totalGuesses++;
            this.currentStreak++;
            if (this.currentStreak > this.longestStreak) {
                this.longestStreak = this.currentStreak;
            }
        } else {
            this.totalGuesses++;
            this.currentStreak = 0;
        }
    }

    public double getAccuracy() {
        if (this.totalGuesses > 0) {
            return (double) this.correctGuesses / this.totalGuesses * 100;
        } else {
            return 0.0;
        }
    }

    public boolean hasMoreCountries() {
        return !deck.isEmpty();
    }

    public int getRemainingCountries() {
        return deck.size();
    }

    public void setCurrentCountry(Country country) {
        this.currentCountry = country;
    }
}
