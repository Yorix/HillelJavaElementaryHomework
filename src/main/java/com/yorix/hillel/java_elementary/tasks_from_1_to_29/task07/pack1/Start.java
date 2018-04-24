package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task07.pack1;

public class Start {
    public static void main(String[] args) {
        Train train = new Train();
        AirJet airJet = new AirJet();
        Car car = new Car();

        Vehicle[] vehicles = {train, airJet, car};

        for (Vehicle vehicle : vehicles) {
            vehicle.buyTicket(1250);
            vehicle.start();
        }
    }
}
