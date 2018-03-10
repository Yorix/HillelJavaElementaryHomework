package task14;

public class Cat extends Pet {

    public Cat(int id, int age, double weight, String colour, String name, boolean isVaccinated) {
        super(id, age, weight, colour, name, isVaccinated);
    }

    public String castVoice() {
        return super.castVoice() + "Meow";
    }
}
