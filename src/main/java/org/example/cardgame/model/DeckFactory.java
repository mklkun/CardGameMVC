package org.example.cardgame.model;

public class DeckFactory {
    public enum DeckType {
        NORMAL,
        SMALL,
        TEST
    }

    public static Deck createDeck(DeckType deckType) {
        switch (deckType) {
            case NORMAL: return new NormalDeck();
            case SMALL: return new SmallDeck();
            case TEST: return new TestDeck();
        }
        return new NormalDeck();
    }
}
