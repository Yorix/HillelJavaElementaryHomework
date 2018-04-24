package com.yorix.hillel.java_elementary.tasks_from_1_to_29.blackjack_25.game;

import java.util.LinkedList;
import java.util.ResourceBundle;

public class Game {
    private ResourceBundle resourceBundle;
    private int numberOfPlayers;
    private boolean demoGame;
    private LinkedList<Player> players = new LinkedList<>();
    private Table table;


    public Game(ResourceBundle resourceBundle, int numberOfPlayers, boolean demoGame, String playerName) {
        this.resourceBundle = resourceBundle;
        this.numberOfPlayers = numberOfPlayers;
        this.demoGame = demoGame;
        if (playerName.length() == 0 || playerName.length() > 20)
            playerName = resourceBundle.getString("key.no.name");

        createPlayers(playerName);
        table = new Table(players);
    }

    private void createPlayers(String humanPlayerName) {
        if (!demoGame) {
            players.add(new Player(humanPlayerName));
        }
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Ai(resourceBundle.getString("key.player") + " " + (i + 1)));
        }
        numberOfPlayers = players.size();
    }

    public Table getTable() {
        return table;
    }
}
