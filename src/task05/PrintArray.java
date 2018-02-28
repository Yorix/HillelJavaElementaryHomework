package task05;

import java.util.Arrays;

abstract class PrintArray {
    static void printArray(int[][] arr) {
        for (int[] anArr : arr) {
            System.out.println(Arrays.toString(anArr));
        }
        System.out.println();
    }
}
