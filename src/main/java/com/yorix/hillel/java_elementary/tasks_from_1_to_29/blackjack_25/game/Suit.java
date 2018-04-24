package com.yorix.hillel.java_elementary.tasks_from_1_to_29.blackjack_25.game;

public enum Suit {
    HEARTS("hearts"), DIAMONDS("diamonds"), CLUBS("clubs"), SPADES("spades");

    private String string;

    Suit(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
