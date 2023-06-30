package com.panish.java8;

public class Java8Test {

    public static void main(String[] args) {
        Java8Test tester = new Java8Test();

        MathOperation addition = (int a, int b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;

        System.out.println(tester.operation(3, 4, addition));
        System.out.println(tester.operation(10, 4, subtraction));
    }

    private int operation(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    interface MathOperation {
        int operation(int a, int b);
    }
}
