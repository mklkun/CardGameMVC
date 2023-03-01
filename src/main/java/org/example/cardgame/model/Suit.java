package org.example.cardgame.model;

public enum Suit {
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3),
    CLUBS(4);

    private final int value;

    Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
