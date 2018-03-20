package blackjack.game;

public class Table {
    private Deck deck;
    private Player[] players;

    Table(int deckSize, int numberOfPlayers, boolean ai) {
        deck = new Deck(deckSize);
        players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers - 1; i++) {
            players[i] = new Player(i);
        }
        if (ai) {
            players[numberOfPlayers - 1] = new Ai(numberOfPlayers - 1);
        } else {
            players[numberOfPlayers - 1] = new Player(numberOfPlayers - 1);
        }
    }

    public Deck getDeck() {
        return deck;
    }

    public Player[] getPlayers() {
        return players;
    }
}
