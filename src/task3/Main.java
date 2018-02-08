package task3;

import java.util.Scanner;

public class Main {
    private static int year;
    private static int century;
    private static int min = 1, max = 2018;

    public static void main(String[] args) {
        year = getYear();
        century = getCentury(year);
        printCentury(year, century);
    }

    private static int getCentury(int year) {
        return (year - 1) / 100 + 1;
    }

    private static int getYear() {
        while (true) {
            System.out.println("Enter the year from " + min + " to " + max);

            String input = new Scanner(System.in).nextLine();
            StringBuilder year = new StringBuilder("0");

            for (int i = 0, len = input.length(); i < len; i++) {
                if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                    year.append(input.charAt(i));
                } else if (Integer.parseInt(year.toString()) >= min && Integer.parseInt(year.toString()) <= max) {
                    return Integer.parseInt(year.toString());
                }
            }
            if (Integer.parseInt(year.toString()) < min || Integer.parseInt(year.toString()) > max) {
                continue;
            }
            return Integer.parseInt(year.toString());
        }
    }

    private static void printCentury(int year, int century) {
        System.out.println(year + " is the " + century + " century.");
    }
}
