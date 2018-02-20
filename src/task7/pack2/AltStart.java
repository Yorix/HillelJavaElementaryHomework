package task7.pack2;

public class AltStart extends task7.pack1.Car {
    public static void main(String[] args) {
        AltStart refuelingCar = new AltStart();
        refuelingCar.fillUp((int) (Math.random() * 40));
        refuelingCar.buyTicket(500);
        refuelingCar.start();
    }
}
