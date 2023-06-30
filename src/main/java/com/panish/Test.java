package com.panish;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Test {

    private static final DecimalFormat decfor = new DecimalFormat("0.00");

    public static void main(String[] args) {
        BigDecimal bg1 = new BigDecimal(9);
        BigDecimal bg2 = new BigDecimal(10);
        System.out.println(bg1.compareTo(bg2));
    }

    public static void m4() {
        BigDecimal bg = new BigDecimal(12.000);
        Double db = new Double(12.000);
        System.out.println(bg);
        System.out.println(db);
    }

    public static void m3() {
        BigDecimal bg1 = new BigDecimal(190.126);
        System.out.println("BigDecimal Number Original: " + bg1);

        BigDecimal bg2 = new BigDecimal(190.126);
        bg2 = bg2.setScale(2 , BigDecimal.ROUND_DOWN);
        System.out.println("BigDecimal Number ROUND_DOWN: " + bg2);

        BigDecimal bg3 = new BigDecimal(190.126);
        bg3 = bg3.setScale(2 , BigDecimal.ROUND_UP);
        System.out.println("BigDecimal Number ROUND_UP: " + bg3);

        BigDecimal bg4 = new BigDecimal(190.145);
        bg4 = bg4.setScale(2 , BigDecimal.ROUND_HALF_EVEN);
        System.out.println("BigDecimal Number ROUND_HALF_EVEN: " + bg4);
    }

    public static void m2() {
        BigDecimal value = new BigDecimal(1.234);
        DecimalFormat decim = new DecimalFormat("#.00");
        Double dbl = new Double(((BigDecimal) value).doubleValue());
        Double db2 = Double.parseDouble(decim.format(value));
        System.out.println(dbl);
        System.out.println(db2);
    }

    public static void m1() {
        // Double num = new Double(123.9876543567);
        // Double num = new Double(123.9800);
        Double temp = null;
        Double num = new Double(190.126);
        System.out.println("Double Number Original: " + num);
        //System.out.println("Double Number: " + decfor.format(num));
        decfor.setRoundingMode(RoundingMode.DOWN);
        System.out.println("Double Number DOWN: " + decfor.format(num));
        decfor.setRoundingMode(RoundingMode.UP);
        System.out.println("Double Number UP: " + decfor.format(num));
        decfor.setRoundingMode(RoundingMode.HALF_EVEN);
        System.out.println("Double Number HALF_EVEN: " + decfor.format(num));
    }
}
