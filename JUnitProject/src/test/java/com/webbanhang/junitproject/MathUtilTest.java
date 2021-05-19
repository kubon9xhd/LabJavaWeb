/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webbanhang.junitproject;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author asus
 */
public class MathUtilTest {

    @Test
    public void divide_SixDividedByTwo_ReturnThree() {
        final int expected = 3;

        final int actual = MathUtil.divide(6, 2);

        Assert.assertEquals(expected, actual);

    }


    @Test
    public void divide_OneDividedByTwo_ReturnZero() {
        final int expected = 0;

        final int actual = MathUtil.divide(1, 2);

        Assert.assertEquals(expected, actual);

    }


    @Test(expected = IllegalArgumentException.class)
    public void divide_OneDividedByZero_ThrowsIllegalArgumentException() {
        MathUtil.divide(1, 0);

    }

    @Test
    public void add_SixAddedByTwo_ReturnEight() {
        final int expected = 8;

        final int actual = MathUtil.add(6, 2);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void sub_FiveSubThree_ReturnTwo() {
        final int expected = 2;
        final int actual = MathUtil.sub(5, 3);
        Assert.assertEquals(expected, actual);

    }


    @Test
    public void mul_TwoMulThree_ReturnSix() {
        final int expected = 6;
        final int actual = MathUtil.mul(3, 2);
        Assert.assertEquals(expected, actual);

    }
}
