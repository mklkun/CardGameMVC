package org.example.cardgame.games;

import org.example.cardgame.model.Card;
import org.example.cardgame.model.Player;
import org.example.cardgame.model.Rank;
import org.example.cardgame.model.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class HighCardGameEvaluatorTest {

    HighCardGameEvaluator highCardGameEvaluator;

    @BeforeEach
    public void setup() {
        highCardGameEvaluator = new HighCardGameEvaluator();
    }

    @Test
    void evaluateWinnerShouldReturnHighCardPlayer() {
        //GIVEN
        List<Player> dummyPlayers = new ArrayList<>();
        Player playerDiamonds = new Player("Jack");
        playerDiamonds.addCardToHand(new Card(Rank.ACE, Suit.DIAMONDS));
        Player playerClubs = new Player("Isabelle");
        playerClubs.addCardToHand(new Card(Rank.ACE, Suit.CLUBS));
        dummyPlayers.add(playerDiamonds);
        dummyPlayers.add(playerClubs);

        //WHEN
        Player winnerPlayer = highCardGameEvaluator.evaluateWinner(dummyPlayers);

        //THEN
        assertThat(winnerPlayer).isEqualTo(playerClubs);
    }

    @Test
    void evaluateWinnerWithOnePlayerShouldReturnThePlayer() {
        //GIVEN
        List<Player> dummyPlayers = new ArrayList<>();
        Player playerDiamonds = new Player("Jack");
        playerDiamonds.addCardToHand(new Card(Rank.ACE, Suit.DIAMONDS));
        dummyPlayers.add(playerDiamonds);

        //WHEN
        Player winnerPlayer = highCardGameEvaluator.evaluateWinner(dummyPlayers);

        //THEN
        assertThat(winnerPlayer).isEqualTo(playerDiamonds);
    }
}