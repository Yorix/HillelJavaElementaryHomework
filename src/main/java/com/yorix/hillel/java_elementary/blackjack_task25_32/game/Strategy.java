package com.yorix.hillel.java_elementary.blackjack_task25_32.game;

@FunctionalInterface
public interface Strategy {
    boolean sayStop(int currentValue);
}
