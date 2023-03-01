package org.example.cardgame.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class SmallDeck extends Deck {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmallDeck.class);

    public SmallDeck() {
        cards = new ArrayList<Card> ();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                if (rank.getValue() >= 7) {
                    LOGGER.info("Creating card: [{}][{}]", rank, suit);
                    cards.add(new Card (rank, suit));
                }
            }
        }
    }
}
