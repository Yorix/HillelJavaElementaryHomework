package MyCalc;

public class MyCalc {
    public static void main(String[] args) {
        System.out.println(add(1, 2));
        System.out.println(sub(9.5, 2.5));
        System.out.println(mul(2, 3.5));
        System.out.println(div(12, 5));
        System.out.println(mod(7, 3));
        System.out.println(avg(mod(7, 3), 2));
        System.out.println(pow(5.5));
        System.out.println(percent(mul(3, 7), 4));

    }

    public static double add(double val1, double val2) {
        return val1 + val2;
    }

    public static double sub(double val1, double val2) {
        return val1 - val2;
    }

    public static double mul(double val1, double val2) {
        return val1 * val2;
    }

    public static double div(double val1, double val2) {
        return val1 / val2;
    }

    public static double mod(double val1, double val2) {
        return val1 % val2;
    }

    public static double avg(double val1, double val2) {
        return (val1 + val2) / 2;
    }

    public static double pow(double val) {
        return val * val;
    }

    public static double percent(double val1, double percent) {
        return val1 * percent / 100;
    }
}

