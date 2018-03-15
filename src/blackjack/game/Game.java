package blackjack.game;

public class Game implements ResetRound {
    public static final int DECK_SIZE = 32;
    private int numberOfPlayers;
    private int numberOfRounds;

    private Table table;
    private Player winner;
    private Player activePlayer;
    private int activePlayerNumber;
    private int roundNumber = 0;

    public Game(int numberOfPlayers, int numberOfRounds) {
        this.numberOfPlayers = numberOfPlayers;
        this.numberOfRounds = numberOfRounds;
        table = new Table(DECK_SIZE, numberOfPlayers);
        winner = new Player();
    }

    @Override
    public void round() {
        activePlayerNumber = 0;
        for (Player player : table.getPlayers()) {
            player.round();
        }
        table.getDeck().round();
        table.getDeck().shuffle();
        activePlayer = table.getPlayers()[activePlayerNumber];
    }

    public String takeCard() {
        if (activePlayer.getPoints() >= 21) {
            return null;
        }
        activePlayer.takeCard(table.getDeck());
        return activePlayer.getPocketCards()[activePlayer.getNumberOfCards() - 1].toString();
    }

    public void pass() {
        activePlayerNumber++;
        if (activePlayerNumber >= numberOfPlayers) {
            if (roundNumber >= numberOfRounds) {
//                gameOver();
            }
            roundNumber++;
            round();
        }
        activePlayer = table.getPlayers()[activePlayerNumber];
    }

//    private void deal() {
//        Player winner = new Player();
//        for (Player player : table.getPlayers()) {
//            pocketCards[player.getId()] = player.getPocketCards();
//            points[player.getId()] = player.getPoints();
//            if (player.getPoints() <= 21 && player.getPoints() > winner.getPoints()) {
//                winner = player;
//            } else if (player.getPoints() == winner.getPoints()) {
//                playRound();
//                return;
//            }
//        }
//        if (winner.getPoints() == 0) {
//            winner = table.getPlayers()[0];
//            for (int i = 1; i < table.getPlayers().length; i++) {
//                if (table.getPlayers()[i].getPoints() < winner.getPoints()) {
//                    winner = table.getPlayers()[i];
//                } else if (table.getPlayers()[i].getPoints() == winner.getPoints()) {
//                    playRound();
//                    return;
//                }
//            }
//        }
//
//
//        winner.upNumberOfWins();
//        round();
//    }

    private void start() {
        for (int i = 0; i < numberOfRounds; i++) {
//            rounds[i] = new Round(table);
        }

        winner = table.getPlayers()[0];
        for (int i = 1; i < table.getPlayers().length; i++) {
            if (table.getPlayers()[i].getNumberOfWins() > winner.getNumberOfWins()) {
                winner = table.getPlayers()[i];
            } else if (table.getPlayers()[i].getNumberOfWins() == winner.getNumberOfWins()) {
                winner = null;
            }
        }
    }

    public int getActivePlayerNumber() {
        return activePlayerNumber;
    }

    public int getRoundNumber() {
        return roundNumber;
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


//    public Round[] getRounds() {
//        return rounds;
//    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }
}
