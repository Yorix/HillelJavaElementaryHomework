package blackjack.game;

public class Game {
    public static final int DECKSIZE = 32;
    private int numberOfPlayers;
    private int numberOfRounds;

    private Table table;
    private Round[] rounds;
    private Player winner;

    public Game(int numberOfPlayers, int numberOfRounds) {
        this.numberOfPlayers = numberOfPlayers;
        this.numberOfRounds = numberOfRounds;
        table = new Table(DECKSIZE, numberOfPlayers);
        rounds = new Round[numberOfRounds];
        winner = new Player();
        start();
    }

    private void start() {
        for (int i = 0; i < numberOfRounds; i++) {
            rounds[i] = new Round(table);
        }

        winner = table.getPlayers()[0];
        for (int i = 1; i < table.getPlayers().length; i++ ) {
            if (table.getPlayers()[i].getNumberOfWins() > winner.getNumberOfWins()) {
                winner = table.getPlayers()[i];
            } else if (table.getPlayers()[i].getNumberOfWins() == winner.getNumberOfWins()) {
                winner = null;
            }
        }
    }

    public String getResultOfGame() {
        StringBuilder builder = new StringBuilder("-------------\n");
        if (winner == null) {
            builder.append("Draw!\n");
        } else {
            builder.append("Player#").append(winner.getId() + 1).append(" won!\n");
        }

        builder.append("-------------\nThe overall result:\n");
        for (Player player : table.getPlayers()) {
            builder.append(" Player#").append(player.getId() + 1).append(" - ").
                    append(player.getNumberOfWins()).append(" won rounds.\n");
        }
        return builder.toString();
    }

    public Round[] getRounds() {
        return rounds;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }
}
