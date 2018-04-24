package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task24;

public class Chiken implements Eatable {
    @Override
    public void eat(String thing) {
        System.out.println(thing + " received 1000 kcal, eating this chicken.");
    }

    @Override
    public String toString() {
        return "Chiken{}";
    }
}
