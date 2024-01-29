package org.sample.java.tenniskata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TennisGame {

    private static final Logger LOGGER = LoggerFactory.getLogger(TennisGame.class);

    // 1. zwei Spieler
    // 2. starte Spiel, per Zufall machte Spieler A oder B den Punkt
    // 3. danach wird der Spielstand ausgegeben

    private static Player playerA;
    private static Player playerB;

    public TennisGame(Player playerA, Player playerB) {
        TennisGame.playerA = playerA;
        TennisGame.playerB = playerB;
    }

    public static Player winnerOfGame() {

        Player winner = null;
        while (winner == null) {
            int random = (int) Math.round(Math.random());
            if (random == 0) { // playerA makes the point
                playerA.setPoints(playerA.getPoints().next());
                winner = validatePlayerA();
            } else { // player B makes the point
                playerB.setPoints(playerB.getPoints().next());
                winner = validatePlayerB();
            }
        }
        return winner;
    }

    private static Player validatePlayerA() {
        log();
        if (playerA.getPoints() == PointsEnum.ADVANTAGE || playerA.getPoints() == PointsEnum.FOURTY && playerB.getPoints() != PointsEnum.FOURTY) {
            return playerA;
        }
        return null;
    }

    private static Player validatePlayerB() {
        log();
        if (playerB.getPoints() == PointsEnum.ADVANTAGE || playerB.getPoints() == PointsEnum.FOURTY && playerA.getPoints() != PointsEnum.FOURTY) {
            return playerB;
        }
        return null;
    }

    private static void log(){
        LOGGER.info(String.format("%s: %s - %s: %s",playerA.getName(), playerA.getPoints(),playerB.getName(),playerB.getPoints() ));
    }


}
