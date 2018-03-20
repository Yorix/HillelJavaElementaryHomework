package blackjack.game;

public class Ai extends Player {

    Ai(int id) {
        super(id);
    }

    @Override
    public Card takeCard(Deck srcDeck) {
        Card card = super.takeCard(srcDeck);
        if (this.getPoints() > 17) this.setFull();
        return card;
    }
}
