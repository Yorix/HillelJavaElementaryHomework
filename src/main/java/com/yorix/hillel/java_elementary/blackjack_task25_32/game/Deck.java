package com.yorix.hillel.java_elementary.blackjack_task25_32.game;

import javafx.collections.ObservableList;

import java.util.LinkedList;

class Deck {
    private LinkedList<Card> cards;

    Deck(int deckSize) {
        cards = new LinkedList<>();
        for (int i = 0; i < deckSize / 4; i++) {
            for (int j = 0; j < 4; j++) {
                cards.add(new Card(Card.Rank.values()[i], Card.Suit.values()[j]));
            }
        }
    }

    void shuffle() {
        for (int i = 0, size = cards.size(); i < size; i++) {
            int tmp = (int) (Math.random() * size);
            Card tmpCard = cards.get(tmp);
            cards.set(tmp, cards.get(i));
            cards.set(i, tmpCard);
        }
    }

    Card pull() {
        return cards.poll();
    }

    void mergePocketCards(ObservableList<Card> pocketCards) {
        cards.addAll(pocketCards);
    }
}
