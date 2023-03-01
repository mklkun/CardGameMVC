package org.example.cardgame.view;

import org.example.cardgame.controller.GameController;

import java.util.Scanner;

public class CommandLineView implements GameView {

    GameController controller;
    Scanner keyboard = new Scanner(System.in);

    public void setController(GameController gc) {
        this.controller = gc;
    }

    public void promptForPlayerName() {
        System.out.println("Enter Player Name:");
        String name = keyboard.nextLine();
        if (name.isEmpty()) {
            controller.startGame();
        } else {
            controller.addPlayer(name);
        }
    }

    public void promptForFlip() {
        System.out.println("Press enter to reveal cards");
        keyboard.nextLine();
        controller.flipCards();
    }

    public void promptForNewGame() {
        System.out.println("Press enter to deal again or enter q to exit.");
        String entry = keyboard.nextLine();
        controller.nextAction(entry);
    }

    public void showWinner(String playerName) {
        System.out.printf("Winner is %s !%n", playerName);
    }

    public void showPlayerName(int playerIndex, String playerName) {
        System.out.printf("[%d][%s]%n", playerIndex, playerName);
    }

    public void showFaceDownCardForPlayer(int i, String playerName) {
        System.out.printf("[%d][%s][x][x]%n", i, playerName);
    }

    public void showCardForPlayer(int i, String playerName, String rank, String suit) {
        System.out.println(String.format("[%d][%s][%s][%s]", i, playerName, rank, suit));
    }

}