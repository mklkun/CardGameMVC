package org.example.cardgame.model;

public class Player {

    private final String name;
    private final Hand hand;


    public Player(String name) {
        this.name = name;
        hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public void addCardToHand(Card pc) {
        hand.addCard(pc);
    }

    public Card getCard(int index) {
        return hand.getCard(index);
    }

    public Card removeCard() {
        return hand.removeCard();
    }
}
