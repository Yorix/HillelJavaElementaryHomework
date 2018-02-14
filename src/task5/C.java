package task5;

public class C extends PrintArray {
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

    public static void main(String[] args) {
        printArray(arr);
        swap();
        printArray(arr);
    }
}
