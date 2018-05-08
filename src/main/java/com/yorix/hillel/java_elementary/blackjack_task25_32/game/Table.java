package com.yorix.hillel.java_elementary.blackjack_task25_32.game;

import com.yorix.hillel.java_elementary.blackjack_task25_32.controllers.GameController;
import javafx.collections.ObservableList;

public class Table {
    private final int DECK_SIZE = 32;
    private Deck deck;
    private ObservableList<Player> players;
    private Player currentPlayer;
    private Player roundWinner;
    private Player gameWinner;
    private final Player noWinners = new Player();
    private int roundNumber;
    private int numberOfRounds;

    private GameController gameController;

    public Table(ObservableList<Player> players) {
        deck = new Deck(DECK_SIZE);
        this.players = players;
        currentPlayer = this.players.get(0);
    }

    public void startGame(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
        startRound();
    }

    public void startRound() {
        roundNumber++;
        for (Player player : players) {
            player.dropPocketCards(deck);
        }
        deck.shuffle();

        currentPlayer = players.get(0);
        gameController.move();
    }

    public void nextMove() {
        if (currentPlayer == players.get(players.size() - 1)) {
            endRound();
            return;
        }
        currentPlayer = players.get(players.indexOf(currentPlayer) + 1);
        gameController.move();
    }

    private void endRound() {
        roundWinner = expose();
        if (roundWinner == noWinners) {
            gameController.restartRound();
            roundNumber--;
            return;
        }
        roundWinner.upNumberOfWins();
        gameController.endRound();
        if (roundNumber == numberOfRounds)
            if (determinationOfWinner() == noWinners) {
                gameController.bonusRound();
                numberOfRounds++;
            } else gameOver();
    }

    private Player expose() {
        int max = 0;
        int min = 32;
        int repeated = 0;
        roundWinner = noWinners;

        for (Player player : players) {
            player.setScore(player.getPoints());
            if (player.getPoints() <= 21 && player.getPoints() > max) {
                max = player.getPoints();
            }
        }

        if (max > 0) {
            for (Player player : players) {
                if (player.getPoints() == max) {
                    roundWinner = player;
                    repeated++;
                }
                if (repeated > 1) {
                    return roundWinner = noWinners;
                }
            }
        } else {
            for (Player player : players) {
                if (player.getPoints() < min && player.getPoints() > 21) {
                    min = player.getPoints();
                }
            }
            for (Player player : players) {
                if (player.getPoints() == min) {
                    roundWinner = player;
                    repeated++;
                }
                if (repeated > 1) {
                    roundWinner = noWinners;
                }
            }
        }
        return roundWinner;
    }

    private Player determinationOfWinner() {
        int max = 0;
        gameWinner = noWinners;

        for (Player player : players) {
            if (player.getWins() >= max) {
                max = player.getWins();
            }
        }

        for (Player player : players) {
            if (player.getWins() == max) {
                if (gameWinner == noWinners) gameWinner = player;
                else {
                    return gameWinner = noWinners;
                }
            }
        }
        return gameWinner;
    }

    private void gameOver() {
        gameController.gameOver();
    }

    public ObservableList<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Deck getDeck() {
        return deck;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public Player getRoundWinner() {
        return roundWinner;
    }

    public Player getGameWinner() {
        return gameWinner;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }
}
