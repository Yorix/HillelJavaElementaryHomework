package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task01_02.MyCalc2;

public class Calc {
    private String expression;
    private double[] numbers;
    private char[] sign;
    private int operationsNumber;

    public Calc(String expression) {
        operationsNumber = 0;
        for (int i = 0, length = expression.length(); i < length; i++) {
            if (expression.charAt(i) == '+' ||
                    expression.charAt(i) == '-' ||
                    expression.charAt(i) == '*' ||
                    expression.charAt(i) == '/') {
                operationsNumber++;
            }
        }
        numbers = new double[operationsNumber + 1];
        sign = new char[operationsNumber];
        this.expression = expression.replaceAll(" ", "");
        assignment();
        System.out.println("==================\n" + calculating());
    }

    private void assignment() {
        int label = 0;
        int j = 0;
        for (int i = 0, length = expression.length(); i < length; i++) {
            if (expression.charAt(i) == '+' ||
                    expression.charAt(i) == '-' ||
                    expression.charAt(i) == '*' ||
                    expression.charAt(i) == '/') {
                sign[j] = expression.charAt(i);
                numbers[j] = Double.parseDouble(expression.substring(label, i));
                label = i + 1;
                j++;
            }
        }
        numbers[operationsNumber] = Double.parseDouble(expression.substring(label));
    }

    private double calculating() {
        for (int i = 0; i < operationsNumber; i++) {
            double result;
            if (sign[i] == '*') {
                result = numbers[i] * numbers[i + 1];
                multDiv(i, result);
                i--;
            } else if (sign[i] == '/') {
                result = numbers[i] / numbers[i + 1];
                multDiv(i, result);
                i--;
            }
        }

        double result = numbers[0];
        for (int i = 0; i < operationsNumber; i++) {
            if (sign[i] == '+') {
                result += numbers[i + 1];
            } else {
                result -= numbers[i + 1];
            }
        }
        return result;
    }

    private void multDiv(int i, double result) {
        System.arraycopy(numbers, i + 1, numbers, i, numbers.length - 1 - i);
        System.arraycopy(sign, i + 1, sign, i, sign.length - 1 - i);
        numbers[i] = result;
        operationsNumber--;
    }
}
