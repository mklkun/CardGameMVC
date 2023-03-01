package org.example.cardgame.games;

import org.example.cardgame.model.Card;
import org.example.cardgame.model.Player;

import java.util.List;

public class LowCardGameEvaluator implements GameEvaluator {

    @Override
    public Player evaluateWinner(List<Player> players) {
        Player bestPlayer = null;
        int bestRank = -1;
        int bestSuit = -1;

        for (Player player : players) {
            boolean newBestPlayer = false;

            if (bestPlayer == null) {
                newBestPlayer = true;
            } else {
                Card pc = player.getCard(0);
                int thisRank = pc.getRank().getValue();
                if (thisRank <= bestRank) {
                    if (thisRank < bestRank) {
                        newBestPlayer = true;
                    } else {
                        if (pc.getSuit().getValue() < bestSuit) {
                            newBestPlayer = true;
                        }
                    }
                }
            }

            if (newBestPlayer) {
                bestPlayer = player;
                Card pc = player.getCard(0);
                bestRank = pc.getRank().getValue();
                bestSuit = pc.getSuit().getValue();
            }
        }

        return bestPlayer;
    }

}
