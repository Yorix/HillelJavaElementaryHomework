package task5;

public class B extends PrintArray {
    private static int[][] arr = new int[10][10];

    public static void main(String[] args) {

        fillAnArray();
        printArray(arr);
        int sum = sumOfArrayElements();
        System.out.println("Sum of array elements: " + sum);
        double avg = avgOfArray();
        System.out.println("Average of array elements: " + avg);
        int min = minimumElement();
        System.out.println("Minimum element: " + min);
        int max = maximumElement();
        System.out.println("Maximum element: " + max);
        int positive = positiveElements();
        System.out.println("Number of positive elements: " + positive);
        int negative = negativeElements();
        System.out.println("Number of negative elements: " + negative);

    }

    private static void fillAnArray() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[10];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 41) - 20;
            }
        }
    }

    private static int sumOfArrayElements() {
        int sum = 0;
        for (int[] anArr : arr) {
            for (int anAnArr : anArr) {
                sum += anAnArr;
            }
        }
        return sum;
    }

    private static double avgOfArray() {
        int sum = sumOfArrayElements();
        return (double) sum / (arr.length * arr[0].length);
    }

    private static int minimumElement() {
        int min = arr[0][0];
        for (int[] anArr : arr) {
            for (int anAnArr : anArr) {
                if (anAnArr < min) {
                    min = anAnArr;
                }
            }
        }
        return min;
    }

    private static int maximumElement() {
        int max = arr[0][0];
        for (int[] anArr : arr) {
            for (int anAnArr : anArr) {
                if (anAnArr > max) {
                    max = anAnArr;
                }
            }
        }
        return max;
    }

    private static int positiveElements() {
        int count = 0;
        for (int[] anArr : arr) {
            for (int anAnArr : anArr) {
                if (anAnArr > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int negativeElements() {
        int count = 0;
        for (int[] anArr : arr) {
            for (int anAnArr : anArr) {
                if (anAnArr < 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
