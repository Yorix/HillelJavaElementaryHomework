package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task05;

import java.util.Arrays;

abstract class PrintArray {
    static void printArray(int[][] arr) {
        for (int[] anArr : arr) {
            System.out.println(Arrays.toString(anArr));
        }
        System.out.println();
    }
}
