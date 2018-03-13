package blackjack.game;

public class Round implements ResetRound {
    private Table table;
    private int[] points;

    Round(Table table) {
        this.table = table;
        points = new int[table.getPlayers().length];
        start();
    }

    private void start() {
        boolean roundContinues;

        table.getDeck().shuffle();

        for (Player player : table.getPlayers()) {
            player.putInGame();
        }

        do {
            for (Player player : table.getPlayers()) {
                turn(player);
            }
            roundContinues = false;
            for (Player player : table.getPlayers()) {
                roundContinues |= player.isInGame();
            }
        } while (roundContinues);

        deal();
    }

    private void turn(Player player) {
        if (player.getPoints() <= 17) {
            player.takeCard(table.getDeck());
        } else {
            player.pass();
        }
    }

    private void deal() {
        Player winner = new Player(table.getDeck().getDeckSize());
        int winnersCount = 0;
        for (Player player : table.getPlayers()) {
            points[player.getId() - 1] = player.getPoints();
            if (player.getPoints() <= 21 && player.getPoints() > winner.getPoints()) {
                winner = player;
                winnersCount = 1;
            } else if (player.getPoints() <= 21 && player.getPoints() == winner.getPoints()) {
                winnersCount++;
            }
        }
        if (winnersCount == 1) {
            winner.upNumberOfWonRounds();
        }
    }

    @Override
    public void resetRound() {
        table.resetRound();
    }

    public int getPlayersPoints(int playerID) {
        return points[playerID - 1];
    }
}
