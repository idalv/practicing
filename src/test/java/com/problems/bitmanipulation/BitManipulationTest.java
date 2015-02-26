package com.problems.bitmanipulation;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/23/15
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class BitManipulationTest {
    @Test
    public void testCombine() {
        Assert.assertEquals(0b10001001100, BitManipulation.combine(0b10000000000, 0b10011, 2, 6));
    }

    @Test
    public void testCombine2() {
        Assert.assertEquals(0b10001001100, BitManipulation.combine(0b10001110000, 0b10011, 2, 6));
    }

    @Test
    public void printBinary() {
        Assert.assertEquals(".1011100001010001111010111000010100011110101110000101", BitManipulation.printBinary(0.72));
    }

    @Test
    public void printNext() {
        Assert.assertEquals(41, BitManipulation.printNext(38));
    }

    @Test
    public void printPrevious() {
        Assert.assertEquals(38, BitManipulation.printPrevious(41));
    }

    @Test
    public void countFlips() {
        Assert.assertEquals(2, BitManipulation.countFlips(29, 15));
    }

    @Test
    public void flipOddEven() {
        Assert.assertEquals(37, BitManipulation.flipOddEven(26));
        Assert.assertEquals(30, BitManipulation.flipOddEven(45));
    }

    @Test
    public void flipOddEvenOptimal() {
        Assert.assertEquals(37, BitManipulation.flipOddEvenOptimal(26));
        Assert.assertEquals(30, BitManipulation.flipOddEvenOptimal(45));
    }
}
