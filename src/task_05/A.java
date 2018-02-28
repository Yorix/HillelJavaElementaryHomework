package task_05;

import java.util.Scanner;

public class A {
    private static boolean isPalindrome(int num) {
        int tempNum = num;
        int count = 0;
        while (tempNum > 0) {
            tempNum /= 10;
            count++;
        }
        tempNum = num;
        int[] numToArray = new int[count];
        for (int i = 0; i < count; i++) {
            numToArray[i] = tempNum % 10;
            tempNum /= 10;
        }
        for (int i = 0, j = count - 1; i < count / 2; i++, j--) {
            if (numToArray[i] != numToArray[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int getInt = new Scanner(System.in).nextInt();
        System.out.println(isPalindrome(getInt));
    }
}
