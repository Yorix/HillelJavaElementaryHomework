package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task14;

public class Wild extends Animal {

    private boolean isPredator;

    public Wild(int id, int age, double weight, String colour, boolean isPredator) {
        super(id, age, weight, colour);
        this.isPredator = isPredator;
    }

    @Override
    public String castVoice() {
        return isPredator ? super.castVoice() + "I am a wild animal and I am angry" : super.castVoice() + "I am a wild animal";
    }

    @Override
    public String habitat() {
        return "habitat: nature";
    }

}
