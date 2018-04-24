package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task07.pack1;

public class Train extends Vehicle {

    Train() {
        setNumberOfSeats(900);
        setSpeed(120);
    }

    @Override
    public void start() {
        if (getTicket().isExist()) {
            System.out.println("Go!");
            setMoves();
            goOutPassengers();
            stop();
        } else {
            System.out.println("... And from the platform they say: \"This is the Leningrad City.\"");
            System.out.println("===================");
        }
    }

    // private method
    private void goOutPassengers() {
        setPassengers(getPassengers() - (int) (getPassengers() * Math.random() / 3));
    }

    @Override
    public String toString() {
        return "train";
    }
}
