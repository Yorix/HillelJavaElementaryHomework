package com.yorix.hillel.java_elementary.tasks_from_1_to_29.blackjack_25.game;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Player {
    private SimpleStringProperty name;
    private ObservableList<Card> pocketCards;
    private int points;
    private SimpleIntegerProperty score;
    private SimpleIntegerProperty wins;
    private boolean isFull;

    Player(String name) {
        this.name = new SimpleStringProperty(name);
        pocketCards = FXCollections.observableArrayList();
        score = new SimpleIntegerProperty(0);
        wins = new SimpleIntegerProperty(0);
    }

    public void takeCard(Deck deck) {
        if (isFull) return;
        Card card = deck.pull();
        pocketCards.add(card);
        points += card.getRank().getValue();
        isFull = points >= 21;
    }

    void dropPocketCards(Deck deck) {
        score.set(0);
        deck.mergePocketCards(pocketCards);
        pocketCards.clear();
        isFull = false;
        points = 0;
    }

    public ObservableList<Card> getPocketCards() {
        return pocketCards;
    }

    public int getPoints() {
        return points;
    }

    void setFull() {
        isFull = true;
    }

    public boolean isFull() {
        return isFull;
    }

    void upNumberOfWins() {
        wins.set(wins.get() + 1);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getWins() {
        return wins.get();
    }

    public SimpleIntegerProperty winsProperty() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins.set(wins);
    }

    public int getScore() {
        return score.get();
    }

    public SimpleIntegerProperty scoreProperty() {
        return score;
    }

    void setScore(int score) {
        this.score.set(score);
    }

    @Override
    public String toString() {
        return name.get();
    }
}
