package com.game;

import com.game.cli.GameCli;

public class Main {
    public static void main(String[] args) {
        try {
            GameCli cli = new GameCli();
            cli.start();
        } catch (Exception e) {
            System.err.println("Error" + e.getMessage());
            e.printStackTrace();
        }
    }
}
