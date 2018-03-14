package blackjack.game;

import java.util.Arrays;

public class Round implements ResetRound {
    private Table table;
    private int[] points;
    private Card[][] pocketCards;

    Round(Table table) {
        this.table = table;
        points = new int[table.getPlayers().length];
        pocketCards = new Card[table.getPlayers().length][table.getPlayers()[0].getPocketCards().length];

        playRound();
    }

    private void playRound() {
        resetRound();
        table.getDeck().shuffle();

        for (Player player : table.getPlayers()) {
            do {
                if (player.getPoints() < 17) {
                    player.takeCard(table.getDeck());
                } else {
                    player.pass();
                }
            } while (player.isInGame());
        }

        deal();
    }

    private void deal() {
        Player winner = new Player();
        for (Player player : table.getPlayers()) {
            pocketCards[player.getId()] = player.getPocketCards();
            points[player.getId()] = player.getPoints();
            if (player.getPoints() <= 21 && player.getPoints() > winner.getPoints()) {
                winner = player;
            } else if (player.getPoints() == winner.getPoints()) {
                playRound();
                return;
            }
        }
        if (winner.getPoints() == 0) {
            winner = table.getPlayers()[0];
            for (int i = 1; i < table.getPlayers().length; i++) {
                if (table.getPlayers()[i].getPoints() < winner.getPoints()) {
                    winner = table.getPlayers()[i];
                } else if (table.getPlayers()[i].getPoints() == winner.getPoints()) {
                    playRound();
                    return;
                }
            }
        }


        winner.upNumberOfWins();
        resetRound();
    }

    @Override
    public void resetRound() {
        for (Player player : table.getPlayers()) {
            player.resetRound();
        }
        table.getDeck().resetRound();
    }

    public int getPlayersPoints(int playerID) {
        return points[playerID];
    }

    public String getPocketCards(int playerID) {
        return Arrays.toString(pocketCards[playerID]);
    }
}
