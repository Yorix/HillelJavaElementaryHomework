package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task14;

public class Test {
    public static void main(String[] args) {
        Animal[] animals = new Animal[9];

        animals[0] = new Cat(1, 4, 4, "Black and white", "Mitya", false);
        animals[1] = new Crocodile(2, 7, 23, "Green");
        animals[2] = new Dog(3, 14, 6, "Red", "Barsik", false);
        animals[3] = new Fish(4, 2, .5, "White", true);
        animals[4] = new Giraffe(5, 17, 185, "Yellow");
        animals[5] = new GuideDog(6, 10, 9, "Black", "Oleg", true, true);
        animals[6] = new Hamster(7, 1, .7, "White", "Vasya", true);
        animals[7] = new Lion(8, 6, 47, "Red");
        animals[8] = new Wolf(9, 4, 22, "Grey");

        for (Animal animal : animals) {
            System.out.println(animal.getClass().getSimpleName());
            System.out.println(animal.castVoice());
            System.out.println(animal.habitat());
            if (animal instanceof GuideDog) {
                ((GuideDog) animal).takeHome();
            }
        }
    }
}
