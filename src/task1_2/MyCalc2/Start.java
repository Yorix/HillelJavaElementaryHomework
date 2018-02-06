package task1_2.MyCalc2;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the expression using decimal numbers, +, -, *, or / ");
        new Calc(in.nextLine());
    }
}

