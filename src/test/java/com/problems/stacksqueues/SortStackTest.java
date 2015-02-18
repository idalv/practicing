package com.problems.stacksqueues;

import org.junit.Assert;
import org.junit.Test;

import com.problems.stacksqueues.sortstack.SortStack;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/18/15
 * Time: 12:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class SortStackTest {
    @Test
    public void testSortStack() {
        Stack<Integer> stack = new SimpleStack<Integer>();
        stack.push(Integer.MAX_VALUE);
        stack.push(1);
        stack.push(5);
        stack.push(4);
        stack.push(4);
        stack.push(3);
        stack.push(Integer.MIN_VALUE);

        Stack<Integer> sorted = SortStack.sortStack(stack);

        Assert.assertEquals(Integer.MAX_VALUE, (int) sorted.pop());
        Assert.assertEquals(5, (int) sorted.pop());
        Assert.assertEquals(4, (int) sorted.pop());
        Assert.assertEquals(4, (int) sorted.pop());
        Assert.assertEquals(3, (int) sorted.pop());
        Assert.assertEquals(1, (int) sorted.pop());
        Assert.assertEquals(Integer.MIN_VALUE, (int) sorted.pop());
    }

    @Test
    public void testSortStackElegantly() {
        Stack<Integer> stack = new SimpleStack<Integer>();
        stack.push(Integer.MAX_VALUE);
        stack.push(1);
        stack.push(5);
        stack.push(4);
        stack.push(4);
        stack.push(3);
        stack.push(Integer.MIN_VALUE);

        Stack<Integer> sorted = SortStack.sortStackElegantly(stack);

        Assert.assertEquals(Integer.MAX_VALUE, (int) sorted.pop());
        Assert.assertEquals(5, (int) sorted.pop());
        Assert.assertEquals(4, (int) sorted.pop());
        Assert.assertEquals(4, (int) sorted.pop());
        Assert.assertEquals(3, (int) sorted.pop());
        Assert.assertEquals(1, (int) sorted.pop());
        Assert.assertEquals(Integer.MIN_VALUE, (int) sorted.pop());
    }
}
