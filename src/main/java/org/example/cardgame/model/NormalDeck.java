package org.example.cardgame.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class NormalDeck extends Deck {

    private static final Logger LOGGER = LoggerFactory.getLogger(NormalDeck.class);

    public NormalDeck() {
        cards = new ArrayList<>();
        for(Rank rank : Rank.values()) {
            for(Suit suit: Suit.values()) {
                LOGGER.info("Creating card: [{}][{}]", rank, suit);
                cards.add(new Card(rank, suit));
            }
        }
    }
}
