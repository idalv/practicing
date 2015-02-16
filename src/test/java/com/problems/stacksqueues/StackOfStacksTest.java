package com.problems.stacksqueues;

import com.problems.stacksqueues.stackofstacks.StackOfStacks;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/16/15
 * Time: 5:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class StackOfStacksTest {
    @Test
    public void testStacks() {
        StackOfStacks<Integer> stacks = new StackOfStacks<Integer>();
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        stacks.push(5);
        stacks.push(6);

        Assert.assertEquals(6, (int) stacks.peek());
        Assert.assertEquals(6, (int) stacks.pop());
        Assert.assertEquals(5, (int) stacks.pop());
        Assert.assertEquals(4, (int) stacks.pop());
        Assert.assertEquals(3, (int) stacks.pop());
        Assert.assertEquals(2, (int) stacks.pop());
        Assert.assertEquals(1, (int) stacks.pop());
    }
}
