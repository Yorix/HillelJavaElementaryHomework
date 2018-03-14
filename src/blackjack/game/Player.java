package blackjack.game;

import java.util.Arrays;

public class Player implements ResetRound {
    private int id;
    private static int count;
    private Card[] pocketCards;
    private int numberOfCards;
    private int points;
    private int numberOfWins;
    private boolean inGame;

    Player() {
        id = count++;
        resetRound();
    }

    void takeCard(Deck srcDeck) {
        inGame = true;
        if (numberOfCards >= pocketCards.length) {
            pocketCards = Arrays.copyOf(pocketCards, pocketCards.length + 1);
        }
        if (numberOfCards >= Game.DECKSIZE) {
            inGame = false;
            return;
        }
        pocketCards[numberOfCards] = srcDeck.give();
        points += pocketCards[numberOfCards].getRank().getValue();
        numberOfCards++;
    }

    void pass() {
        inGame = false;
    }

    int getPoints() {
        return points;
    }

    boolean isInGame() {
        return inGame;
    }

    void upNumberOfWins() {
        numberOfWins++;
    }

    int getNumberOfWins() {
        return numberOfWins;
    }

    Card[] getPocketCards() {
        return pocketCards;
    }

    int getId() {
        return id;
    }

    @Override
    public void resetRound() {
        pocketCards = new Card[2];
        numberOfCards = 0;
        points = 0;
    }
}
