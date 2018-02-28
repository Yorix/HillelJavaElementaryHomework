package task07.pack1;

public class AirJet extends Vehicle {

    AirJet() {
        setNumberOfSeats(8);
        setSpeed(550);
    }

    @Override
    public void start() {
        if (getTicket().isExist()) {
            System.out.println("Flew!");
            setMoves();
            accelerate();
        }
        stop();
    }

    // private method
    private void accelerate() {
        int speedIncrement = (int) (getSpeed() * Math.random() / 3);
        setSpeed(getSpeed() + speedIncrement);
    }

    @Override
    public String toString() {
        return "Air Jet";
    }
}
