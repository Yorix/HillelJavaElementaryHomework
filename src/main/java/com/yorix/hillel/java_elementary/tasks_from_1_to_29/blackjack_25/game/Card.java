package com.yorix.hillel.java_elementary.tasks_from_1_to_29.blackjack_25.game;

import javafx.scene.image.Image;

public class Card {
    private final Rank rank;
    private final Suit suit;
    private final Image img;

    Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        img = new Image("com/yorix/hillel/java_elementary/tasks_from_1_to_29/blackjack_25/resources/deck/" + toString());
    }

    public Rank getRank() {
        return rank;
    }

    public Image getImg() {
        return img;
    }

    @Override
    public String toString() {
        return rank + "_of_" + suit + ".png";
    }
}
