package com.panish.inter;

public class Test {
    public static void main(String[] args) {
        System.out.println(new TestA() {
            public String toString() { return "test"; }
        });
    }
}

interface TestA { String toString(); }
