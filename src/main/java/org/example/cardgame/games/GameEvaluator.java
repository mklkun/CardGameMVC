package org.example.cardgame.games;

import org.example.cardgame.model.Player;

import java.util.List;

public interface GameEvaluator {
    public Player evaluateWinner(List<Player> players);
}
