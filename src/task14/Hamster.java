package task14;

public class Hamster extends Animal {
    private Wild wild;
    private Pet pet;

    public Hamster(int id, int age, double weight, String colour) {
        super(id, age, weight, colour);
        wild = new Wild(id, age, weight, colour, false);
    }

    public Hamster(int id, int age, double weight, String colour, String name, boolean isVaccinated) {
        super(id, age, weight, colour);
        pet = new Pet(id, age, weight, colour, name, isVaccinated);
    }

    @Override
    public String castVoice() {
        return (wild == null) ? pet.castVoice() : wild.castVoice();
    }

    @Override
    public String habitat() {
        return wild == null ? pet.habitat() : wild.habitat();
    }
}
