package task24;

public class Fish implements Eatable {
    @Override
    public void eat(String thing) {
        System.out.println(thing + " received 500 kcal, eating this fish.");
    }

    @Override
    public String toString() {
        return "Fish{}";
    }
}
