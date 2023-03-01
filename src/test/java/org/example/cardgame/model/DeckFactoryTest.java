package org.example.cardgame.model;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.example.cardgame.model.Deck;
import org.example.cardgame.model.DeckFactory;
import org.example.cardgame.model.Rank;
import org.example.cardgame.model.Suit;
import org.junit.jupiter.api.Test;

class DeckFactoryTest {

    private static final int RANK_VALUES_NUMBER = 12;

    private static final int SUIT_VALUES_NUMBER = 4;

    @Test
    void createNormalDeckShouldAdd32CardsToDeck() {
        // GIVEN
        Assertions.assertThat(Rank.values()).hasSize(RANK_VALUES_NUMBER);
        Assertions.assertThat(Suit.values()).hasSize(SUIT_VALUES_NUMBER);

        // WHEN
        Deck createdDeck = DeckFactory.createDeck(DeckFactory.DeckType.NORMAL);

        // THEN
        Assertions.assertThat(createdDeck).has(new Condition<>(
                m -> m.getCards().size() == RANK_VALUES_NUMBER*SUIT_VALUES_NUMBER,
                "Normal deck should contain all cards"
        ));
    }

    @Test
    void createSmallDeckShouldAdd28CardsToDeck() {
        // GIVEN
        Assertions.assertThat(Rank.values()).hasSize(RANK_VALUES_NUMBER);
        Assertions.assertThat(Suit.values()).hasSize(SUIT_VALUES_NUMBER);

        // WHEN
        Deck createdDeck = DeckFactory.createDeck(DeckFactory.DeckType.SMALL);

        // THEN
        Assertions.assertThat(createdDeck).has(new Condition<>(
                m -> m.getCards().size() == 28,
                "Small deck should contain 20 cards"
        ));
    }

    @Test
    void createTestDeckShouldAdd20CardsToDeck() {
        // GIVEN
        Assertions.assertThat(Rank.values()).hasSize(RANK_VALUES_NUMBER);
        Assertions.assertThat(Suit.values()).hasSize(SUIT_VALUES_NUMBER);

        // WHEN
        Deck createdDeck = DeckFactory.createDeck(DeckFactory.DeckType.TEST);

        // THEN
        Assertions.assertThat(createdDeck).has(new Condition<>(
                m -> m.getCards().size() == 20,
                "Test deck should contain 20 cards"
        ));
    }
}