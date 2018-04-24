package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task07.pack2;

public class AltStart extends com.yorix.hillel.java_elementary.tasks_from_1_to_29.task07.pack1.Car {
    public static void main(String[] args) {
        AltStart refuelingCar = new AltStart();
        refuelingCar.fillUp((int) (Math.random() * 40));
        refuelingCar.buyTicket(500);
        refuelingCar.start();
    }
}
