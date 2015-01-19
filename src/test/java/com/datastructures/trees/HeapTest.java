package com.datastructures.trees;

import com.datastructures.trees.Heap;
import org.junit.Test;
import org.junit.Assert;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/19/15
 * Time: 12:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class HeapTest {
    @Test
    public void testEnqueue() {
        Heap heap = new Heap();

        Assert.assertEquals("[]", heap.toString());

        heap.enqueue(15);
        Assert.assertEquals("[15]", heap.toString());

        heap.enqueue(7);
        Assert.assertEquals("[15, 7]", heap.toString());

        heap.enqueue(8);
        Assert.assertEquals("[15, 7, 8]", heap.toString());

        heap.enqueue(5);
        Assert.assertEquals("[15, 7, 8, 5]", heap.toString());

        heap.enqueue(4);
        Assert.assertEquals("[15, 7, 8, 5, 4]", heap.toString());

        heap.enqueue(6);
        Assert.assertEquals("[15, 7, 8, 5, 4, 6]", heap.toString());

        heap.enqueue(3);
        Assert.assertEquals("[15, 7, 8, 5, 4, 6, 3]", heap.toString());

        heap.enqueue(10);
        Assert.assertEquals("[15, 10, 8, 7, 4, 6, 3, 5]", heap.toString());
    }

    @Test
    public void testDequeue() {
        Heap heap = new Heap();

        heap.enqueue(15);
        heap.enqueue(7);
        heap.enqueue(8);
        heap.enqueue(5);
        heap.enqueue(4);
        heap.enqueue(6);
        heap.enqueue(3);

        heap.dequeue();
        Assert.assertEquals("[8, 7, 6, 5, 4, 3]", heap.toString());

        heap.dequeue();
        Assert.assertEquals("[7, 5, 6, 3, 4]", heap.toString());

        heap.dequeue();
        Assert.assertEquals("[6, 5, 4, 3]", heap.toString());

        heap.dequeue();
        Assert.assertEquals("[5, 3, 4]", heap.toString());

        heap.dequeue();
        Assert.assertEquals("[4, 3]", heap.toString());

        heap.dequeue();
        Assert.assertEquals("[3]", heap.toString());

        heap.dequeue();
        Assert.assertEquals("[]", heap.toString());
    }
}
