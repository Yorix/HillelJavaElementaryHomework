package blackjack.game;

public class Player implements ResetRound {
    private int id;
    private static int count;
    private Card[] pocketCards;
    private int numberOfCards;
    private int points;
    private int numberOfWonRounds;
    private boolean inGame;

    Player(int deckSize) {
        count++;
        id = count;
        pocketCards = new Card[deckSize];
    }

    public void takeCard(Deck srcDeck) {
        if (numberOfCards < pocketCards.length - 1) {
            pocketCards[numberOfCards] = srcDeck.give();
            points += pocketCards[numberOfCards].getRank().getValue();
            numberOfCards++;
            return;
        }
        inGame = false;
    }

    public void pass() {
        inGame = false;
    }

    public int getPoints() {
        return points;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void putInGame() {
        inGame = true;
    }

    public void upNumberOfWonRounds() {
        numberOfWonRounds++;
    }

    public int getNumberOfWonRounds() {
        return numberOfWonRounds;
    }

    public int getId() {
        return id;
    }

    @Override
    public void resetRound() {
        pocketCards = new Card[pocketCards.length];
        numberOfCards = 0;
        points = 0;
    }
}
