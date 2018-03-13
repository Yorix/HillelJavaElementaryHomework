package blackjack.game;

public class Game {
    private final int DECKSIZE = 52;
    private int numberOfPlayers;
    private int numberOfRounds;

    private Table table;
    private Round[] rounds;
    private Player winner;
    private int maxNumOfWins;

    public Game(int numberOfPlayers, int numberOfRounds) {
        this.numberOfPlayers = numberOfPlayers;
        this.numberOfRounds = numberOfRounds;
        table = new Table(DECKSIZE, numberOfPlayers);
        rounds = new Round[numberOfRounds];
        winner = new Player(DECKSIZE);
        start();
    }

    private void start() {
        for (int i = 0; i < numberOfRounds; i++) {
            rounds[i] = new Round(table);
            rounds[i].resetRound();
        }

        maxNumOfWins = 0;
        for (Player player : table.getPlayers()) {
            if (player.getNumberOfWonRounds() > winner.getNumberOfWonRounds()) {
                winner = player;
                maxNumOfWins = winner.getNumberOfWonRounds();
            }
        }
    }

    public String getResultOfGame() {
        StringBuilder string = new StringBuilder("-------------\n");
        for (Player player : table.getPlayers()) {
            if (player.getNumberOfWonRounds() == maxNumOfWins && player.getNumberOfWonRounds() != 0) {
                string.append("Player#").append(player.getId()).append(" won!\n");
            }
        }
        string.append("-------------\nThe overall result:\n");
        for (Player player : table.getPlayers()) {
            string.append(" Player#").append(player.getId()).append(" - ").
                    append(player.getNumberOfWonRounds()).append(" won rounds.\n");
        }
        return string.toString();
    }

    public Round[] getRounds() {
        return rounds;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public int getDECKSIZE() {
        return DECKSIZE;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }
}
