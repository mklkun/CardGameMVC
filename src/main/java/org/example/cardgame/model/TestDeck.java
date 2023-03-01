package org.example.cardgame.model;

import java.util.ArrayList;

public class TestDeck extends Deck {

    public TestDeck() {
        cards = new ArrayList<>();
        for (int i = 0; i < 20; ++i) {
            cards.add(new Card (Rank.ACE, Suit.CLUBS));
        }
    }
}
