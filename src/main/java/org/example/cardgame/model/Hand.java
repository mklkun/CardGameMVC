package org.example.cardgame.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card pc) {
        cards.add(pc);
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public Card removeCard() {
        return cards.remove(0);
    }
}
