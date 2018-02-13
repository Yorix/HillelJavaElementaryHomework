package task5;

import java.util.Arrays;

public class C {
    private static int[][] arr = {
            {1, 6},
            {2, 7},
            {3, 8},
            {4, 9},
            {5, 0}
    };

    private static void swap() {
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i][0];
            arr[i][0] = arr[i][1];
            arr[i][1] = tmp;
        }
    }

    private static void printArray() {
        for (int[] anArr : arr) {
            System.out.println(Arrays.toString(anArr));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printArray();
        swap();
        printArray();
    }
}
