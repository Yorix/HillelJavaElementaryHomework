package com.yorix.hillel.java_elementary.blackjack_task25_32.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card {
    private final Rank rank;
    private final Suit suit;
    private final Image img;

    Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        img = new Image("/img/deck/" + toString());
    }

    public int getValue() {
        return rank.value;
    }

    public ImageView getImgView() {
        return new ImageView(img);
    }

    @Override
    public String toString() {
        return rank + "_of_" + suit + ".png";
    }


    enum Rank {
        SEVEN(7, "7"), EIGHT(8, "8"), NINE(9, "9"), TEN(10, "10"), JACK(2, "jack"), QUEEN(3, "queen"), KING(4, "king"), ACE(11, "ace");

        private int value;
        private String string;

        Rank(int value, String string) {
            this.value = value;
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }

    enum Suit {
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
}
