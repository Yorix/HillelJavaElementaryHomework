package com.yorix.hillel.java_elementary.tasks_from_1_to_29.blackjack_25.game;

public enum Rank {
    SEVEN(7, "7"), EIGHT(8, "8"), NINE(9, "9"), TEN(10, "10"), JACK(2, "jack"), QUEEN(3, "queen"), KING(4, "king"), ACE(11, "ace");

    private int value;
    private String string;

    Rank(int value, String string) {
        this.value = value;
        this.string = string;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return string;
    }
}
