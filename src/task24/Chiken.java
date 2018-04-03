package task24;

public class Chiken implements Eatable {
    @Override
    public void eat(String thing) {
        System.out.println(thing + " received 1000 kcal, eating this chicken.");
    }

    @Override
    public String toString() {
        return "Chiken{}";
    }
}
