package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task14;

public class GuideDog extends Dog {

    private boolean isTrained;

    public GuideDog(int id, int age, double weight, String colour, String name, boolean isVaccinated, boolean isTrained) {
        super(id, age, weight, colour, name, isVaccinated);
        this.isTrained = isTrained;
    }

    public String castVoice() {
        return isTrained ? super.castVoice() + ". I can take you home." : super.castVoice();
    }

    public void takeHome() {
        if (isTrained) {
            System.out.println("Let's go home.");
        }
        else {
            System.out.println("And what do you want from me?");
        }
    }
}
