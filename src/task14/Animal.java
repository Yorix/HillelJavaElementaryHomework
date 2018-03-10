package task14;

public abstract class Animal {

    private int id;
    private int age;
    private double weight;
    private String colour;

    public Animal(int id, int age, double weight, String colour) {
        this.id = id;
        this.age = age;
        this.weight = weight;
        this.colour = colour;
    }

    public String castVoice() {
        return "Hello, ";
    }

    public abstract String habitat();
}
