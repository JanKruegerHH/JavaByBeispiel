package org.sample.java.tenniskata;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TennisGameTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TennisGameTest.class);

    @Test
    public void testTennisGame(){
        TennisGame tennisGame = new TennisGame(new Player("Boris"),new Player("Steffi"));
        Player winner = TennisGame.winnerOfGame();
        LOGGER.info("Winner: " + winner.getName());
    }

}
