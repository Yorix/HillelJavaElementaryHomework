package blackjack;

import blackjack.game.Game;

public class Program {
    public static void main(String[] args) {
        Game game = new Game(2, 5);
        System.out.println(game.getResultOfGame());
        for (int i = 0; i < game.getNumberOfRounds(); i++) {
            System.out.println("Round " + (i + 1));
            for (int j = 1; j <= game.getNumberOfPlayers(); j++) {
                int points = game.getRounds()[i].getPlayersPoints(j);
                System.out.printf(" Player#%d points: %d\n", j, points);
            }
        }
    }
}
