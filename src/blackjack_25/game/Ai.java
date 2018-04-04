package blackjack_25.game;

public class Ai extends Player {

    Ai(int id) {
        super(id);
    }

    @Override
    public Card takeCard(Deck deck) {
        Card card = super.takeCard(deck);
        if (this.getPoints() > 17) this.setFull();
        return card;
    }
}
