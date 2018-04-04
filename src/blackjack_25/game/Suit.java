package blackjack_25.game;

public enum Suit {
    HEARTS("hearts"), DIAMONDS("diamonds"), CLUBS("clubs"), SPADES("spades");

    private String string;

    Suit(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
