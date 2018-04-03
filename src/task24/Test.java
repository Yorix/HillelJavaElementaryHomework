package task24;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Eatable> food = new LinkedList<>();

        food.add(new Chiken());
        food.add(new Fish());

        Eatable worm = new Eatable() {
            @Override
            public void eat(String thing) {
                System.out.println(thing + ": Fu!");
            }
        };
        food.add(worm);

        //////// или без червей вообще:

        food.add(new Eatable() {
            @Override
            public void eat(String thing) {
                System.out.println(thing + ": Fu!");
            }
        });


        food.getFirst().eat("I");
        food.get(1).eat("You");
        food.getLast().eat("He");
    }


}
