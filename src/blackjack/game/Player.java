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
        round();
    }


    void takeCard(Deck srcDeck) {
        if (numberOfCards >= pocketCards.length) {
            pocketCards = Arrays.copyOf(pocketCards, pocketCards.length + 1);
        }
        if (numberOfCards >= Game.DECK_SIZE) {
            inGame = false;
            return;
        }
        pocketCards[numberOfCards] = srcDeck.give();
        points += pocketCards[numberOfCards].getRank().getValue();
        numberOfCards++;
    }

//    void pass() {
//        inGame = false;
//    }

    int getPoints() {
        return points;
    }

    public void putInGame() {
        inGame = true;
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

    public int getNumberOfCards() {
        return numberOfCards;
    }

    @Override
    public void round() {
        pocketCards = new Card[2];
        numberOfCards = 0;
        points = 0;
    }
}
