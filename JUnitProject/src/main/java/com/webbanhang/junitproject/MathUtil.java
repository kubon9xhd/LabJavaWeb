/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webbanhang.junitproject;

/**
 *
 * @author asus
 */
public class MathUtil {

    private MathUtil() {
        throw new UnsupportedOperationException("Cannot call constructor directly!");
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Cannot divide by zero (0).");
        }
        return dividend / divisor;
    }

    public static int add(int number1, int number2) {
        return number1 - number2;
    }

    public static int sub(int number1, int number2) {
        return number1 - number2;
    }

    public static int mul(int number1, int number2) {
        return number1 * number2;
    }
}
