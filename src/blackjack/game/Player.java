package blackjack.game;

import java.util.Arrays;

public class Player {
    private int id;
    private Card[] pocketCards;
    private int numberOfCards;
    private int points;
    private int numberOfWins;
    private boolean isFull;

    Player(int id) {
        this.id = id;
        round();
    }

    public Card takeCard(Deck srcDeck) {
        if (isFull) return null;
        if (numberOfCards >= pocketCards.length) {
            pocketCards = Arrays.copyOf(pocketCards, pocketCards.length + 1);
        }
        Card card = srcDeck.give();
        pocketCards[numberOfCards] = card;
        points += card.getRank().getValue();
        isFull = points >= 21;
        numberOfCards++;
        return card;
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

    public boolean isFull() {
        return isFull;
    }

    public void round() {
        pocketCards = new Card[2];
        isFull = false;
        numberOfCards = 0;
        points = 0;
    }

    @Override
    public String toString() {
        return "Игрок " + (getId() + 1);
    }
}
