package task14;

public class Fish extends Animal{
    private Wild wild;
    private Pet pet;

    public Fish(int id, int age, double weight, String colour, boolean isPredator) {
        super(id, age, weight, colour);
        wild = new Wild(id, age, weight, colour, isPredator);
    }

    public Fish(int id, int age, double weight, String colour, String name, boolean isVaccinated) {
        super(id, age, weight, colour);
        pet = new Pet(id, age, weight, colour, name, isVaccinated);
    }

    @Override
    public String castVoice() {
        return "....";
    }

    @Override
    public String habitat() {
        return wild == null ? pet.habitat() : wild.habitat();
    }
}
