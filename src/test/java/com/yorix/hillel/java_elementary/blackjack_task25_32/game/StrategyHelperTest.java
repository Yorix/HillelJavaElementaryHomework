package com.yorix.hillel.java_elementary.blackjack_task25_32.game;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.yorix.hillel.java_elementary.blackjack_task25_32.game.StrategyHelper.*;

public class StrategyHelperTest {

    @Test
    public void testSelectStrategy() {
        assertFalse(selectStrategy(Ai.Complexity.GREEN).sayStop(5));
        assertFalse(selectStrategy(Ai.Complexity.GREEN).sayStop(12));
        assertTrue(selectStrategy(Ai.Complexity.GREEN).sayStop(13));
        assertTrue(selectStrategy(Ai.Complexity.GREEN).sayStop(20));

        assertFalse(selectStrategy(Ai.Complexity.ADVANCE).sayStop(12));
        assertFalse(selectStrategy(Ai.Complexity.ADVANCE).sayStop(14));
        assertTrue(selectStrategy(Ai.Complexity.ADVANCE).sayStop(15));
        assertTrue(selectStrategy(Ai.Complexity.ADVANCE).sayStop(25));

        assertFalse(selectStrategy(Ai.Complexity.EXPERT).sayStop(1));
        assertFalse(selectStrategy(Ai.Complexity.EXPERT).sayStop(16));
        assertTrue(selectStrategy(Ai.Complexity.EXPERT).sayStop(17));
        assertTrue(selectStrategy(Ai.Complexity.EXPERT).sayStop(21));
    }
}