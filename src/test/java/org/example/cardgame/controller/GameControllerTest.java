package org.example.cardgame.controller;

import org.assertj.core.api.Assertions;
import org.example.cardgame.games.HighCardGameEvaluator;
import org.example.cardgame.model.DeckFactory;
import org.example.cardgame.view.GameView;
import org.junit.contrib.java.lang.system.internal.NoExitSecurityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
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

    @BeforeEach
    void setup() {
        gameController = Mockito.spy(new GameController(DeckFactory.createDeck(DeckFactory.DeckType.TEST),
                gameView,
                highCardGameEvaluator));
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
    void startGameShouldCallRunIfCardsDealtState() {
        //GIVEN
        gameController.gameState = GameController.GameState.CARDS_DEALT;
        Mockito.doNothing().when(gameController).run();

        //WHEN
        gameController.startGame();

        //THEN
        Mockito.verify(gameController).run();
    }

    @Test
    void flipCards() {
    }

    @Test
    void nextActionShouldQuitWhenEntryIsQ() {
        //GIVEN
        String userEntry = "q";
        Mockito.doNothing().when(gameController).exitGame();

        //WHEN
        gameController.nextAction(userEntry);

        //THEN
        Mockito.verify(gameController).exitGame();
    }

    @Test
    void nextActionShouldStartGameWhenEntryIsNotQ() {
        //GIVEN
        String userEntry = "";
        Mockito.doNothing().when(gameController).startGame();

        //WHEN
        gameController.nextAction(userEntry);

        //THEN
        Mockito.verify(gameController).startGame();
    }

    @Test
    void exitGame() {
        //GIVEN
        System.setSecurityManager(new NoExitSecurityManager(System.getSecurityManager()));
        int exitCode = -1;

        //WHEN
        try {
            gameController.exitGame();
        } catch (RuntimeException e) {
            LOGGER.info("Game exited: [{}]", e.getMessage());
            String key = "Tried to exit with status ";
            String codeDigit = e.getMessage().substring(key.length()).replace(".", "").trim();
            exitCode = Integer.parseInt(codeDigit);
        }

        //
        int expectedExitCode = 0;
        Assertions.assertThat(exitCode).isEqualTo(expectedExitCode);
    }
}