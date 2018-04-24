package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task01_02.MyCalc2;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the expression using decimal numbers, +, -, *, or / ");
        new Calc(in.nextLine());

    }
}

