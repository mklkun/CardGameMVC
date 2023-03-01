package org.example.cardgame.controller;

import org.example.cardgame.games.GameEvaluator;
import org.example.cardgame.model.Card;
import org.example.cardgame.model.Deck;
import org.example.cardgame.model.Player;
import org.example.cardgame.view.GameView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public enum GameState {
        ADDING_PLAYERS, CARDS_DEALT, WINNER_REVEALED;
    }

    Deck deck;
    List<Player> players;
    Player winner;
    GameView gameView;
    GameState gameState;
    GameEvaluator evaluator;

    public GameController(Deck deck, GameView gameView, GameEvaluator gameEvaluator) {
        super();
        this.deck = deck;
        this.gameView = gameView;
        this.players = new ArrayList<>();
        this.gameState = GameState.ADDING_PLAYERS;
        this.evaluator = gameEvaluator;
        gameView.setController(this);
    }

    public void run() {
        while (gameState == GameState.ADDING_PLAYERS) {
            gameView.promptForPlayerName();
        }

        switch (gameState) {
            case CARDS_DEALT:
                gameView.promptForFlip();
                break;
            case WINNER_REVEALED:
                gameView.promptForNewGame();
                break;
            default:
                throw new IllegalStateException("Unknown game state.");
        }
    }

    public void addPlayer(String playerName) {
        if (gameState == GameState.ADDING_PLAYERS) {
            players.add(new Player(playerName));
            gameView.showPlayerName(players.size(), playerName);
        }
    }

    public void startGame() {
        if (gameState != GameState.CARDS_DEALT) {
            deck.shuffle();
            int playerIndex = 1;
            for (Player player : players) {
                player.addCardToHand(deck.getTopCard());
                gameView.showFaceDownCardForPlayer(playerIndex++, player.getName());
            }
            gameState = GameState.CARDS_DEALT;
        }
        this.run();
    }

    public void flipCards() {
        int playerIndex = 1;
        for (Player player : players) {
            Card pc = player.getCard(0);
            pc.flip();
            gameView.showCardForPlayer(playerIndex++, player.getName(),
                                              pc.getRank().toString(), pc.getSuit().toString());
        }

        evaluateWinner();
        displayWinner();
        rebuildDeck();
        gameState = GameState.WINNER_REVEALED;
        this.run();
    }

    public void nextAction(String entry) {
        if ("q".equals(entry)) {
            exitGame();
        } else {
            startGame();
        }
    }

    public void exitGame() {
        System.exit(0);
    }

    void evaluateWinner() {
        winner = evaluator.evaluateWinner(players);
    }

    void displayWinner() {
        gameView.showWinner(winner.getName());
    }

    void rebuildDeck() {
        for (Player player : players) {
            deck.returnCardToDeck(player.removeCard());
        }
    }

}