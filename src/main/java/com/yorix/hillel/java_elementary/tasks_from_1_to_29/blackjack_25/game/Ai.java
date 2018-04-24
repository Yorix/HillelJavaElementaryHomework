package com.yorix.hillel.java_elementary.tasks_from_1_to_29.blackjack_25.game;

public class Ai extends Player {

    Ai(String name) {
        super(name);
    }

    @Override
    public void takeCard(Deck deck) {
        super.takeCard(deck);
        if (this.getPoints() > 17) this.setFull();
    }
}
