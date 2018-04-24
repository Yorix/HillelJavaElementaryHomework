package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task14;

public class Fish extends Animal{
    private Animal fish;

    public Fish(int id, int age, double weight, String colour, boolean isPredator) {
        super(id, age, weight, colour);
        fish = new Wild(id, age, weight, colour, isPredator);
    }

    public Fish(int id, int age, double weight, String colour, String name, boolean isVaccinated) {
        super(id, age, weight, colour);
        fish = new Pet(id, age, weight, colour, name, isVaccinated);
    }

    @Override
    public String castVoice() {
        return "....";
    }

    @Override
    public String habitat() {
        return fish.habitat();
    }
}
