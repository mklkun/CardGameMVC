package org.example.cardgame.view;

import org.example.cardgame.controller.GameController;

public interface GameView {
    void setController(GameController gc);

    void promptForPlayerName();

    void promptForFlip();

    void promptForNewGame();

    void showWinner(String playerName);

    void showPlayerName(int playerIndex, String playerName);

    void showFaceDownCardForPlayer(int i, String playerName);

    void showCardForPlayer(int i, String playerName, String rank, String suit);
}
