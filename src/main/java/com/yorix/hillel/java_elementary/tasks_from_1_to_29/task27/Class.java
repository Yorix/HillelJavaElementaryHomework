package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task27;

public class Class {

    public static void main(String[] args) {
        int[] nums = new int[] {3, 4, -2, 8};
        long result = 0;
        try {
            result = processPositiveNumbers(nums, '+');
        } catch (NonZeroArgsException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    public static long processPositiveNumbers(int[] nums, char op) throws NonZeroArgsException {
        long result = 0;
        for (int num : nums) {
            if (num < 0) {
                throw new NonZeroArgsException("Arguments are less zero.");
            }
            switch (op) {
                case '+':
                    result += num;
                    break;
                case '-':
                    result -= num;
                    break;
                case '*':
                    result *= num;
                    break;
                default:
                    throw new InvalidOperationException("Not supported operation.");
            }
        }
        return result;
    }
}
