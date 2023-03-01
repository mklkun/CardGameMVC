package org.example.cardgame.controller;

import org.assertj.core.api.Assertions;
import org.example.cardgame.games.HighCardGameEvaluator;
import org.example.cardgame.model.DeckFactory;
import org.example.cardgame.view.GameView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(MockitoExtension.class)
class GameControllerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameControllerTest.class);

    GameController gameController;

    @Mock
    GameView gameView;

    @Mock
    HighCardGameEvaluator highCardGameEvaluator;

    AutoCloseable autoCloseable;

    @BeforeEach
    void setup() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        gameController = new GameController(DeckFactory.createDeck(DeckFactory.DeckType.TEST),
                gameView,
                highCardGameEvaluator);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void runningGameInStateAddingPlayersShouldPromptForPlayerName() {
        //GIVEN
        Assertions.assertThat(gameController.gameState).isEqualTo(GameController.GameState.ADDING_PLAYERS);
        Mockito.doNothing().doThrow(new RuntimeException("Second call to promptForPlayerName fails.")).when(gameView).promptForPlayerName();

        //WHEN
        try {
            gameController.run();
        } catch (RuntimeException e) {
            LOGGER.info(e.getMessage());
        }

        //THEN
        Mockito.verify(gameView, Mockito.times(2)).promptForPlayerName();
    }

    @Test
    void runningGameInStateCardsDealtShouldPromptForFlip() {
        //GIVEN
        gameController.gameState = GameController.GameState.CARDS_DEALT;
        Mockito.doNothing().when(gameView).promptForFlip();

        //WHEN
        gameController.run();

        //THEN
        Mockito.verify(gameView, Mockito.times(1)).promptForFlip();
    }

    @Test
    void runningGameInStateWinnerRevealedShouldPromptForNewGame() {
        //GIVEN
        gameController.gameState = GameController.GameState.WINNER_REVEALED;
        Mockito.doNothing().when(gameView).promptForNewGame();

        //WHEN
        gameController.run();

        //THEN
        Mockito.verify(gameView, Mockito.times(1)).promptForNewGame();
    }

    @Test
    void addPlayer() {
        //GIVEN

        //WHEN

        //THEN
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