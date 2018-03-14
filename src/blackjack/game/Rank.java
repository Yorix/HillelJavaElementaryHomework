package blackjack.game;

public enum Rank {
    SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(2), QUEEN(3), KING(4), ACE(11);

    int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
