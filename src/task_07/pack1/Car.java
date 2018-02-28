package task_07.pack1;

public class Car extends Vehicle {
    private double fuel;
    private double fuelConsumption;

    public Car() {
        setNumberOfSeats(5);
        setSpeed(200);
        fuel = 10;
        fuelConsumption = 8;
    }

    @Override
    public void start() {
        if (getTicket().isExist()) {
            System.out.println("Go!");
            setMoves();
            countFuel(getTicket().getDistance());
        } else {
            System.out.println("They went without you!!!");
        }
        stop();
    }

    // private method
    private void countFuel(double distance) {
        double passed = fuel / fuelConsumption * 100;
        if (distance >= passed) {
            getTicket().setDistance(passed);
            System.out.printf("The fuel is over. Passed %.0f km.\n", passed);
        }
    }

    // protected method
    protected void fillUp(int fuel) {
        this.fuel += fuel;
    }

    @Override
    public String toString() {
        return "car";
    }
}
