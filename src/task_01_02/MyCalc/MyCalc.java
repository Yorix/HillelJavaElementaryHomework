package task_01_02.MyCalc;

public class MyCalc {
    public static void main(String[] args) {

        System.out.println("1.-----------------------------");
/*
        double a, b;
        a = 20;
        b = 30;

        System.out.println(a + " + " + b + " = " + add(a, b));
        System.out.println(a + " - " + a + " = " + sub(a, b));
        System.out.println(a + " * " + b + " = " + mul(a, b));
        System.out.println(a + " / " + b + " = " + div(a, b));
        System.out.println(a + " % " + b + " = " + mod(a, b));
        System.out.println("avg(" + a + ", " + b + ") = " + avg(a, b));
        System.out.println(a + " ^ 2 = " + pow(a));
        System.out.println(b + " % of " + a + " = " + percent(a, b));
*/

        System.out.println("2.-----------------------------a)");
        /*
        а) Написать ф-цию со следующим контрактом:
    public static long castToLong(double val);
	Реализовать соответствующую операцию привидения типа (casting).
    В методе main передайте разные значения и проанализируйте результат.
        */

        System.out.println("128.0 to Long: " + castToLong(128.0));
        System.out.println("2048.4096 to Long: " + castToLong(2048.4096));
        System.out.println("203842.69472564839274 to Long: " + castToLong(203842.69472564839274));

        System.out.println("-----------------------------b)");
        /*
        b) Реализовать ф-цию с контрактом:
   public static byte checkSign(byte b);
   В том случае, если число отрицательное ф-ция должна выводить значение всегда -128, а иных случаях 0.
        */

        System.out.println(checkSign((byte) -5));
        System.out.println(checkSign((byte) -128));
        System.out.println(checkSign((byte) -127));
        System.out.println(checkSign((byte) 0));
        System.out.println(checkSign((byte) 64));
        System.out.println(checkSign((byte) 127));

        System.out.println("-----------------------------c)");
        /*
        c) Реализовать ф-цию с контрактом:
    public static int checkEvenNumber(double value);
    Ф-ция должна реализовать проверку четности числа без учета дробной части числа.
    Если число чётное ф-ция выводит число 1, во всех остальных случаях 0.
    Испробуйте эту ф-цию с четными и нечетными числами.
        */
        System.out.println(checkEvenNumber(11.852));
        System.out.println(checkEvenNumber(15836.1));
        System.out.println(checkEvenNumber(0));
        System.out.println(checkEvenNumber(-15));

        System.out.println("-----------------------------d)");
        /*
        d)    Реализовать фук-цию со следующим контрактом:
    public static long bitWiseDivByFour(double number);
    Реализовать ф-цию быстрого деления числа на 4 с помощью битовых операций.
    Поэкспериментируйте передавая разные значения, например: 100, 32, 8, 6, 4, 3, 1, 0, -100.
        */
        System.out.println(bitWiseDivByFour(100));
        System.out.println(bitWiseDivByFour(32));
        System.out.println(bitWiseDivByFour(8));
        System.out.println(bitWiseDivByFour(6));
        System.out.println(bitWiseDivByFour(4));
        System.out.println(bitWiseDivByFour(3));
        System.out.println(bitWiseDivByFour(1));
        System.out.println(bitWiseDivByFour(0));
        System.out.println(bitWiseDivByFour(-100));
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

    public static long castToLong(double val) {
        return (long) val;
    }

    public static byte checkSign(byte b) {
        return (byte) (b & -128);
    }

    public static int checkEvenNumber(double value) {

        return (int) value & 1 ^ 1;
    }

    public static long bitWiseDivByFour(double number) {
        return (long) number >> 2;
    }

}
