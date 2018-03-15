package blackjack.game;

import java.util.Arrays;

public class Deck implements ResetRound {
    private Card[] cards;
    private int deckSize;

    Deck(int deckSize) {
        this.deckSize = deckSize;
        round();
    }
    
    public void shuffle() {
        for (int i = 0, size = cards.length; i < size; i++) {
            int tmp = (int) (Math.random() * size);
            Card tmpCard = cards[tmp];
            cards[tmp] = cards[i];
            cards[i] = tmpCard;
        }
    }

    public Card give() {
        if (cards.length > 0) {
            Card given = cards[cards.length - 1];
            cards = Arrays.copyOf(cards, cards.length - 1);
            return given;
        }
        return null;
    }

    public int getDeckSize() {
        return deckSize;
    }

    @Override
    public void round() {
        cards = new Card[deckSize];
        for (int i = 0, k = 0; i < deckSize / 4; i++) {
            for (int j = 0; j < 4; j++, k++) {
                cards[k] = new Card(Rank.values()[i], Suit.values()[j]);
            }
        }
    }
}
