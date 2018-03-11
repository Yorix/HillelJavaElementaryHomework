package task14;

public class Hamster extends Animal {
    private Animal hamster;

    public Hamster(int id, int age, double weight, String colour) {
        super(id, age, weight, colour);
        hamster = new Wild(id, age, weight, colour, false);
    }

    public Hamster(int id, int age, double weight, String colour, String name, boolean isVaccinated) {
        super(id, age, weight, colour);
        hamster = new Pet(id, age, weight, colour, name, isVaccinated);
    }

    @Override
    public String castVoice() {
        return hamster.castVoice();
    }

    @Override
    public String habitat() {
        return hamster.habitat();
    }
}
