package org.example.cardgame.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Deck {

    private static final Logger LOGGER = LoggerFactory.getLogger(Deck.class);

    private static final Random random = new Random();

    protected List<Card> cards;

    public void shuffle() {
        for (int i = 0; i < cards.size(); ++i) {
            Collections.swap(cards, i, random.nextInt (cards.size()));
        }
        LOGGER.info("Cards shuffled.");
    }

    public Card getTopCard() {
        return cards.remove(0);
    }

    public void returnCardToDeck(Card pc) {
        cards.add(pc);
    }

    public List<Card> getCards() {
        return cards;
    }
}
