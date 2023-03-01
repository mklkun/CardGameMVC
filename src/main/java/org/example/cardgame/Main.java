package org.example.cardgame;

import org.example.cardgame.controller.GameController;
import org.example.cardgame.games.HighCardGameEvaluator;
import org.example.cardgame.model.DeckFactory;
import org.example.cardgame.view.CommandLineView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        LOGGER.info("Hello world!");
        GameController gameController = new GameController(DeckFactory.createDeck(DeckFactory.DeckType.NORMAL),
                                                           new CommandLineView(),
                                                           new HighCardGameEvaluator());
        gameController.run();
    }
}