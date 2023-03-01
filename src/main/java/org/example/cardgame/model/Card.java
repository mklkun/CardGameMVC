package org.example.cardgame.model;

public class Card {
    private final Rank rank;
    private final Suit suit;

    private boolean faceUp;

    public Card(Rank rank, Suit suit) {
        super();
        this.rank = rank;
        this.suit = suit;
    }
    public Rank getRank() {
        return rank;
    }
    public Suit getSuit() {
        return suit;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public boolean flip() {
        faceUp = !faceUp;
        return faceUp;
    }
}
