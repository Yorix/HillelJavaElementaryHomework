package blackjack_25.game;

import java.util.LinkedList;

public class Deck {
    private LinkedList<Card> cards;

    Deck(int deckSize) {
        cards = new LinkedList<>();
        for (int i = 0, k = 0; i < deckSize / 4; i++) {
            for (int j = 0; j < 4; j++, k++) {
                cards.add(new Card(Rank.values()[i], Suit.values()[j]));
            }
        }
    }
    
    public void shuffle() {
        for (int i = 0, size = cards.size(); i < size; i++) {
            int tmp = (int) (Math.random() * size);
            Card tmpCard = cards.get(tmp);
            cards.set(tmp, cards.get(i));
            cards.set(i, tmpCard);
        }
    }

    public Card pull() {
        return cards.poll();
    }

    public void mergePocketCards(LinkedList<Card> pocketCards) {
        cards.addAll(pocketCards);
    }
}
