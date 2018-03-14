package blackjack;

import blackjack.game.Game;

public class Program {
    public static void main(String[] args) {
        Game game = new Game(2, 10);
        System.out.println(game.getResultOfGame());

        for (int i = 0; i < game.getNumberOfRounds(); i++) {
            System.out.println("Round " + (i + 1));
            for (int j = 0; j < game.getNumberOfPlayers(); j++) {
                int points = game.getRounds()[i].getPlayersPoints(j);
                String cards = game.getRounds()[i].getPocketCards(j);
                System.out.printf(" Player#%d points: %d %s\n", j + 1, points, cards);
            }
        }
    }
}
