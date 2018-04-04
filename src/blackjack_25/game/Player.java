package blackjack_25.game;

import java.util.LinkedList;

public class Player {
    private int id;
    private LinkedList<Card> pocketCards;
    private int points;
    private int numberOfWins;
    private boolean isFull;

    Player(int id) {
        this.id = id;
        pocketCards = new LinkedList<>();
    }

    public Card takeCard(Deck deck) {
        if (isFull) return null;
        Card card = deck.pull();
        pocketCards.add(card);
        points += card.getRank().getValue();
        isFull = points >= 21;
        return card;
    }

    public void dropPocketCards(Deck deck) {
        deck.mergePocketCards(pocketCards);
        pocketCards.clear();
        isFull = false;
        points = 0;
    }

    int getPoints() {
        return points;
    }

    void upNumberOfWins() {
        numberOfWins++;
    }

    int getNumberOfWins() {
        return numberOfWins;
    }

    int getId() {
        return id;
    }

    public void setFull() {
        isFull = true;
    }

    public boolean isFull() {
        return isFull;
    }

    @Override
    public String toString() {
        return "Игрок " + (id + 1);
    }
}
