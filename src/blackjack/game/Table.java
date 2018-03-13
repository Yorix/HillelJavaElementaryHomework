package blackjack.game;

public class Table implements ResetRound {
    private Deck deck;
    private Player[] players;

    Table(int deckSize, int numberOfPlayers) {
        deck = new Deck(deckSize);
        players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            players[i] = new Player(deckSize);
        }
    }

    public Deck getDeck() {
        return deck;
    }

    public Player[] getPlayers() {
        return players;
    }

    @Override
    public void resetRound() {
        for (Player player : players) {
            player.resetRound();
        }
        deck.resetRound();
    }
}
