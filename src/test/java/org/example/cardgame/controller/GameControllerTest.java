package org.example.cardgame.controller;

import org.example.cardgame.games.HighCardGameEvaluator;
import org.example.cardgame.model.DeckFactory;
import org.example.cardgame.view.CommandLineView;
import org.example.cardgame.view.GameView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GameControllerTest {

    @Mock
    GameView gameView;
    GameController gameController;

    @BeforeEach
    public void setup() {
        gameView = new CommandLineView();
        gameController = new GameController(DeckFactory.createDeck(DeckFactory.DeckType.TEST),
                                            gameView,
                                            new HighCardGameEvaluator());
    }

    @Test
    void runningGameInStateAddingPlayersShouldPromptForPlayerName() {
        //GIVEN


        //WHEN
//        gameController.run();

        //THEN
//        verify(gameView).promptForPlayerName();
//        assertEquals(true, true);
//        assertThat()
    }

    @Test
    void runningGameInStateCardsDealtShouldPromptForFlip() {

    }

    @Test
    void runningGameInStateWinnerRevealedShouldPromptForNewGame() {

    }

    @Test
    void addPlayer() {
    }

    @Test
    void startGame() {
    }

    @Test
    void flipCards() {
    }

    @Test
    void nextAction() {
    }

    @Test
    void exitGame() {
    }
}