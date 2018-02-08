package task3;

import java.util.Scanner;

public class Main {
    private static final int MIN = 1, MAX = 2018;

    public static void main(String[] args) {
        int year = getYear();
        int century = getCentury(year);
        printCentury(year, century);
        wantToContinue();
    }

    private static int getCentury(int year) {
        return (year - 1) / 100 + 1;
    }

    private static int getYear() {
        while (true) {
            System.out.println("Enter the year from " + MIN + " to " + MAX);

            String input = new Scanner(System.in).nextLine();
            StringBuilder year = new StringBuilder("0");

            for (int i = 0, len = input.length(); i < len; i++) {
                if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                    year.append(input.charAt(i));
                } else if (Integer.parseInt(year.toString()) >= MIN && Integer.parseInt(year.toString()) <= MAX) {
                    return Integer.parseInt(year.toString());
                }
            }
            if (Integer.parseInt(year.toString()) < MIN || Integer.parseInt(year.toString()) > MAX) {
                continue;
            }
            return Integer.parseInt(year.toString());
        }
    }

    private static void printCentury(int year, int century) {
        System.out.println(year + " is the " + century + " century.");
    }

    private static void wantToContinue() {
        System.out.print("Continue? (y/n) ");
        String input = new Scanner(System.in).next();
        if (input.equals("y"))
            main(null);
        else System.exit(0);
    }
}
