package com.problems.stacksqueues;

import org.junit.Assert;
import org.junit.Test;
import com.problems.stacksqueues.towerofhanoi.TowersOfHanoi;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/17/15
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class TowersOfHanoiTest {
    @Test
    public void testHanoi() {
        TowersOfHanoi hanoi = new TowersOfHanoi(5);
        Stack<Integer> destination = new SimpleStack<Integer>();
        hanoi.move(destination);

        Assert.assertEquals(0, (int) destination.pop());
        Assert.assertEquals(1, (int) destination.pop());
        Assert.assertEquals(2, (int) destination.pop());
        Assert.assertEquals(3, (int) destination.pop());
        Assert.assertEquals(4, (int) destination.pop());
    }
}
