package task14;

public class Pet extends Animal {

    private String name;
    private boolean isVaccinated;

    public Pet(int id, int age, double weight, String colour, String name, boolean isVaccinated) {
        super(id, age, weight, colour);
        this.name = name;
        this.isVaccinated = isVaccinated;
    }

    @Override
    public String castVoice() {
        return super.castVoice() + "my name is " + name + ". ";
    }

    @Override
    public String habitat() {
        return "habitat: flat";
    }
}
