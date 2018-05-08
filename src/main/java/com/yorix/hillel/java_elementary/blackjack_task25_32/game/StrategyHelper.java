package com.yorix.hillel.java_elementary.blackjack_task25_32.game;

class StrategyHelper {
    static Strategy selectStrategy(Ai.Complexity complexity) {
        return currentValue -> {
            if (complexity == Ai.Complexity.EXPERT) {
                return currentValue >= 17;
            } else if (complexity == Ai.Complexity.ADVANCE) {
                return currentValue >= 15;
            } else if (complexity == Ai.Complexity.GREEN) {
                return currentValue >= 13;
            }
            return currentValue >= 21;
        };
    }
}
