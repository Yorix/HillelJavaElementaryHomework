package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task04;

import java.util.Scanner;

public class LoopsAndConditions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("a.\nEnter month number: ");
        int month = scanner.nextByte();
        System.out.println(seasonByMonthUsingIf(month));

        System.out.print("Enter month number: ");
        month = scanner.nextByte();
        System.out.println(seasonByMonthUsingSwitch(month));

        System.out.println("\nb.");
        forLoop();

        System.out.println("\nc.");
        coinToss();

        System.out.println("\nd.");
        doWhileLoop();

        System.out.println("\ne.");
        multiplicationTable();

        System.out.print("\nf.\n Enter the number: ");
        System.out.println("Sum of digits in number: " + sum(scanner.nextInt()));

        System.out.print("\ng.\n Enter the number: ");
        System.out.println("Factorial: " + factorial(scanner.nextInt()));

        System.out.println("\nh.");
        progression();
    }

    private static String seasonByMonthUsingIf(int month) {
        if (month < 1 || month > 12) {
            return "Incorrect month number";
        } else if (month < 3 || month == 12) {
            return "Winter";
        } else if (month < 6) {
            return "Spring";
        } else if (month < 9) {
            return "Summer";
        } else {
            return "Autumn";
        }
    }

    private static String seasonByMonthUsingSwitch(int month) {
        switch (month) {
            case 12:
            case 1:
            case 2:
                return "Winter";
            case 3:
            case 4:
            case 5:
                return "Spring";
            case 6:
            case 7:
            case 8:
                return "Summer";
            case 9:
            case 10:
            case 11:
                return "Autumn";
            default:
                return "Incorrect month number";
        }
    }

    private static void forLoop() {
        for (int i = 1; i <= 20; i++) {
            if (i == 6 || i == 12 || i == 18) {
                continue;
            }
            System.out.println("Race " + i);
        }
    }

    private static void coinToss() {
        do {
            double rnd = Math.rint(Math.random() * 100) / 100; // округлил до сотых, иначе окончания ждать очень долго, мягко говоря.
            if (rnd == 0.0) {
                System.out.println(rnd);
                break;
            } else if (rnd > .5) {
                System.out.println("eagle " + rnd);
            } else {
                System.out.println("tails " + rnd);
            }
        }
        while (true);
    }

    private static void doWhileLoop() {
        int count = 10;
        do {
            System.out.println(count);
            count--;
        }
        while (count > 0);
    }

    private static void multiplicationTable() {
        int i = 1;
        while (i < 10) {
            int j = 1;
            while (j < 10) {
                System.out.printf("%d * %d = %d\n", i, j, i * j);
                j++;
            }
            i++;
            System.out.println();
        }
    }

    private static int sum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    private static long factorial(int num) {
        int res = 1;
        for (int i = 1; i <= num; i++) {
            res *= i;
        }
        return res;
    }

    private static void progression() {
        for (int i = 10; i < 40; i +=2) {
            System.out.print(i + " ");
        }
    }
}
