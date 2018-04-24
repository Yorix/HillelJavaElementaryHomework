package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task14;

public class Cat extends Pet {

    public Cat(int id, int age, double weight, String colour, String name, boolean isVaccinated) {
        super(id, age, weight, colour, name, isVaccinated);
    }

    public String castVoice() {
        return super.castVoice() + "Meow";
    }
}
