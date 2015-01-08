package com.datastructures.singlelinkedlist;

import org.junit.Assert;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

/**
 * Created with IntelliJ IDEA.
 * User: vladi
 * Date: 1/6/15
 * Time: 6:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class SingleLinkedListTest {
    @Test
    public void testAddAfterInEmpty() {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.addAfter(null, new Node<Integer>(1));

        Assert.assertTrue(list.contains(new Node<Integer>(1)));
    }

    @Test
    public void testAddBeforeInOneElement() {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.addAfter(null, new Node<Integer>(2));
        list.addBefore(new Node<Integer>(2), new Node<Integer>(1));

        Assert.assertEquals("12", list.print());
    }

    @Test
    public void testAddAfterInTwoElements() {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.addAfter(null, new Node<Integer>(1));
        list.addAfter(new Node<Integer>(1), new Node<Integer>(3));
        list.addBefore(new Node<Integer>(3), new Node<Integer>(2));

        Assert.assertEquals("123", list.print());
    }

    @Test
    public void testDelete() {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.addAfter(null, new Node<Integer>(1));
        list.addAfter(new Node<Integer>(1), new Node<Integer>(3));
        list.addBefore(new Node<Integer>(3), new Node<Integer>(2));
        list.delete(new Node<Integer>(2));

        Assert.assertEquals("13", list.print());
    }

    @Test
    public void testDeleteLast() {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.addAfter(null, new Node<Integer>(1));
        list.addAfter(new Node<Integer>(1), new Node<Integer>(3));
        list.addBefore(new Node<Integer>(3), new Node<Integer>(2));
        list.delete(new Node<Integer>(3));

        Assert.assertEquals("12", list.print());
    }

    @Test
    public void testDeleteFirst() {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.addAfter(null, new Node<Integer>(1));
        list.addAfter(new Node<Integer>(1), new Node<Integer>(3));
        list.addBefore(new Node<Integer>(3), new Node<Integer>(2));
        list.delete(new Node<Integer>(1));

        Assert.assertEquals("23", list.print());
    }

    @Test
    public void testDeleteInOne() {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.addAfter(null, new Node<Integer>(1));
        list.delete(new Node<Integer>(1));

        Assert.assertEquals("", list.print());
    }

}
