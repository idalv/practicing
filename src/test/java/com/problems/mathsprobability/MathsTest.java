package com.problems.mathsprobability;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/26/15
 * Time: 2:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class MathsTest {
    @Test
    public void testMultiply() {
        Assert.assertEquals(0, Maths.multiply(-1, 0));
        Assert.assertEquals(35, Maths.multiply(7, 5));
        Assert.assertEquals(-35, Maths.multiply(-7, 5));
        Assert.assertEquals(35, Maths.multiply(-7, -5));
        Assert.assertEquals(-35, Maths.multiply(7, -5));
    }

    @Test
    public void testSubtract() {
        Assert.assertEquals(2, Maths.subtract(7, 5));
        Assert.assertEquals(-12, Maths.subtract(-7, 5));
        Assert.assertEquals(-2, Maths.subtract(-7, -5));
        Assert.assertEquals(2, Maths.subtract(-5, -7));
        Assert.assertEquals(12, Maths.subtract(7, -5));
    }

    @Test
    public void testDivide() throws InvalidArgumentException {
        Assert.assertEquals(7, Maths.divide(35, 5));
        Assert.assertEquals(-7, Maths.divide(-35, 5));
        Assert.assertEquals(-7, Maths.divide(35, -5));
        Assert.assertEquals(0, Maths.divide(7, 35));
        Assert.assertEquals(0, Maths.divide(0, 35));
    }


    @Test(expected = InvalidArgumentException.class)
    public void testDivideByZero() throws InvalidArgumentException {
        Maths.divide(7, 0);
    }
}
