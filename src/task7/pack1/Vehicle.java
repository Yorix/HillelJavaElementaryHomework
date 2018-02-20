package task7.pack1;

public class Vehicle {
    private int numberOfSeats;
    private int passengers;
    private int speed;
    private boolean moves;
    private Ticket ticket = new Ticket();

    // private method
    private int freePlaces() {
        passengers = (int) (Math.random() * numberOfSeats) + numberOfSeats / 3; // Boarding passengers on the vehicle with a shortage of seats.
        if (numberOfSeats <= passengers) {
            passengers = numberOfSeats;
            return 0;
        }
        return numberOfSeats - passengers;
    }

    // public method
    public void buyTicket(int distance) {
        if (freePlaces() != 0) {
            ticket.setExist(true);
            ticket.setDistance(distance);
            System.out.printf("You bought a ticket for the %s!\n", this.toString());
        } else {
            System.out.println("There are no more places!");
        }
        System.out.printf("The %s boarded %d people.\n", this.toString(), getPassengers());
    }

    public void start() {
        if (ticket.isExist()) {
            System.out.println("Go!");
            setMoves();
            stop();
        } else {
            System.out.println("You don't have a ticket.");
            stop();
        }
    }

    // default-package method
    void stop() {
        if (moves) {
            double time = durationOfTheTravel();
            double distance = ticket.getDistance();
            System.out.printf("You traveled by %s a distance of %.0f km for %.1f hours " +
                    "in the company of %d passengers.\n", this.toString(), distance, time, passengers);
        }
        System.out.println("===================");
    }

    // private method
    private double durationOfTheTravel() {
        return ticket.getDistance() / speed;
    }

    // setter
    void setSpeed(int speed) {
        this.speed = speed;
    }

    void setMoves() {
        this.moves = true;
    }

    void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    // getter
    int getPassengers() {
        return passengers;
    }

    int getSpeed() {
        return speed;
    }

    Ticket getTicket() {
        return ticket;
    }
}
