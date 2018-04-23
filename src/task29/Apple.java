package task29;

public class Apple extends Fruit implements Juiceable {
    @Override
    public void makeJuice() {
        System.out.println("Apple juice");
    }
}
