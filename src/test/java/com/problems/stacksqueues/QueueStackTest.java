package com.problems.stacksqueues;

import org.junit.Assert;
import org.junit.Test;
import com.problems.stacksqueues.queuestack.QueueStack;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/18/15
 * Time: 11:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class QueueStackTest {
    @Test
    public void testQueueStack() {
        QueueStack<Integer> queue = new QueueStack<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        Assert.assertEquals(1, (int) queue.dequeue());
        Assert.assertEquals(2, (int) queue.dequeue());

        queue.enqueue(5);
        queue.enqueue(6);

        Assert.assertEquals(3, (int) queue.dequeue());
        Assert.assertEquals(4, (int) queue.dequeue());

    }
}
