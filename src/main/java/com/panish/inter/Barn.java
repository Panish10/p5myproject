package com.panish.inter;

public class Barn {
    public static void main(String[] args) {
        //new Barn().go("hi", 1);
        //new Barn().go("hi", "world", 2);

        new Barn().go(1, "hi");
        new Barn().go(2, "hi", "world");
    }

    /*public void go(String... y, int x) {
        System.out.print(y[y.length - 1] + " ");
    }*/

    public void go( int x, String... y) {
        System.out.print(y[y.length - 1] + " ");
    }
}
