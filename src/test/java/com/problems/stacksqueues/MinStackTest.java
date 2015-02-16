package com.problems.stacksqueues;

import com.problems.stacksqueues.minstack.MinStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/16/15
 * Time: 10:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class MinStackTest {
    @Test
    public void testMinStack() {
        MinStack stack = new MinStack();

        stack.push(3);
        stack.push(7);
        Assert.assertEquals(3, (int )stack.min());

        stack.push(1);
        Assert.assertEquals(1, (int )stack.min());

        stack.pop();
        Assert.assertEquals(3, (int )stack.min());
    }
}
