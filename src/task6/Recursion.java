package task6;

import java.util.Scanner;

public class Recursion {
    private static final int K = 3;

    private static long sum(int n) {
        if (n <= 1) {
            return n * K;
        }
        return K * n + sum(n - 1);
    }

    private static boolean compare(char[] firstArr, char[] secondArr) {
        if (firstArr == null || secondArr == null) {
            return false;
        }
        if (firstArr == secondArr) {
            return true;
        }
        if (firstArr.length != secondArr.length) {
            return false;
        }
        int i = 0;
        for (char element : firstArr) {
            if (element != secondArr[i]) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 0;
        while (n < 1 || n > 30) {
            System.out.print("Enter a number between 1 and 30: ");
            n = new Scanner(System.in).nextInt();
        }
        System.out.println("The result of calculation the expression 3*1 + 3*2 + ... + 3*n: " + sum(n));

        char[] arr1 = {'t', 'h', 'i', 's', 'i', 's', 't', 'r', 'u', 'e'};
        char[] arr2 = {116, 104, 105, 115, 105, 115, 116, 114, 117, 101};
        if (compare(arr1, arr2)) {
            System.out.println("Arrays are the same");
        } else {
            System.out.println("Arrays are different");
        }
    }
}
