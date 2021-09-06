package com.problems.linkedlists;

import com.datastructures.singlelinkedlist.Node;
import com.datastructures.singlelinkedlist.SingleLinkedList;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/12/15
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinkedListsTest {
    @Test
    public void testRemoveDuplicates() {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.addAfter(null, new Node<Integer>(1));
        list.addAfter(new Node<Integer>(1), new Node<Integer>(2));
        list.addAfter(new Node<Integer>(2), new Node<Integer>(3));
        list.addAfter(new Node<Integer>(3), new Node<Integer>(2));
        list.addAfter(new Node<Integer>(3), new Node<Integer>(1));

        Assert.assertEquals("12312", list.print());

        Assert.assertEquals("123", LinkedLists.removeDuplicates(list).print());
    }

    @Test
    public void testKthNode() {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.addAfter(null, new Node<Integer>(1));
        list.addAfter(new Node<Integer>(1), new Node<Integer>(2));
        list.addAfter(new Node<Integer>(2), new Node<Integer>(3));
        list.addAfter(new Node<Integer>(3), new Node<Integer>(2));
        list.addAfter(new Node<Integer>(3), new Node<Integer>(1));

        Assert.assertEquals("12312", list.print());

        Assert.assertEquals((Object) 3, LinkedLists.getKthToTheLast(list, 3).data);
    }

    @Test
    public void testKthNodeRecursively() {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.addAfter(null, new Node<Integer>(1));
        list.addAfter(new Node<Integer>(1), new Node<Integer>(2));
        list.addAfter(new Node<Integer>(2), new Node<Integer>(3));
        list.addAfter(new Node<Integer>(3), new Node<Integer>(2));
        list.addAfter(new Node<Integer>(3), new Node<Integer>(1));

        Assert.assertEquals("12312", list.print());
        LinkedLists.getKthToTheLastRecursively(list.head, 3);
        Assert.assertEquals(3, LinkedLists.kthNode.data);
    }

    @Test
    public void testKthNodeRecursively2() {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.addAfter(null, new Node<Integer>(1));
        list.addAfter(new Node<Integer>(1), new Node<Integer>(2));
        list.addAfter(new Node<Integer>(2), new Node<Integer>(3));
        list.addAfter(new Node<Integer>(3), new Node<Integer>(2));
        list.addAfter(new Node<Integer>(3), new Node<Integer>(1));

        Assert.assertEquals("12312", list.print());
        Assert.assertEquals((Object) 3, LinkedLists.getKthToTheLastRecursively(list, 3).data);
    }

    @Test
    public void testKthNodeRecursively3() {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.addAfter(null, new Node<Integer>(1));
        list.addAfter(new Node<Integer>(1), new Node<Integer>(2));
        list.addAfter(new Node<Integer>(2), new Node<Integer>(3));
        list.addAfter(new Node<Integer>(3), new Node<Integer>(2));
        list.addAfter(new Node<Integer>(3), new Node<Integer>(1));

        Assert.assertEquals("12312", list.print());

        Node<Integer> result = new Node<Integer>(-1);
        LinkedLists.getKthToTheLastRecursively3(list.head, 3, result);
        Assert.assertEquals((Object) 3, result.data);
    }

    @Test
    public void testAddReversedLists() {
        SingleLinkedList<Integer> first = new SingleLinkedList<Integer>();
        first.addAfter(null, new Node<Integer>(7));
        first.addAfter(new Node<Integer>(7), new Node<Integer>(1));
        first.addAfter(new Node<Integer>(1), new Node<Integer>(6));

        SingleLinkedList<Integer> second = new SingleLinkedList<Integer>();
        second.addAfter(null, new Node<Integer>(5));
        second.addAfter(new Node<Integer>(5), new Node<Integer>(9));
        second.addAfter(new Node<Integer>(9), new Node<Integer>(2));

        Assert.assertEquals("219",
                new SingleLinkedList<Integer>(LinkedLists.addReversedLists(first.head, second.head)).print());
    }

    @Test
    public void testAddLists() {
        SingleLinkedList<Integer> first = new SingleLinkedList<Integer>();
        first.addAfter(null, new Node<Integer>(7));
        first.addAfter(new Node<Integer>(7), new Node<Integer>(1));
        first.addAfter(new Node<Integer>(1), new Node<Integer>(6));

        SingleLinkedList<Integer> second = new SingleLinkedList<Integer>();
        second.addAfter(null, new Node<Integer>(1));
        second.addAfter(new Node<Integer>(1), new Node<Integer>(9));
        second.addAfter(new Node<Integer>(9), new Node<Integer>(2));

        Assert.assertEquals("908", LinkedLists.addLists(first.head, second.head).print());
    }

    @Test
    public void testAddListsCarry() {
        SingleLinkedList<Integer> first = new SingleLinkedList<Integer>();
        first.addAfter(null, new Node<Integer>(7));
        first.addAfter(new Node<Integer>(7), new Node<Integer>(1));
        first.addAfter(new Node<Integer>(1), new Node<Integer>(6));

        SingleLinkedList<Integer> second = new SingleLinkedList<Integer>();
        second.addAfter(null, new Node<Integer>(2));
        second.addAfter(new Node<Integer>(2), new Node<Integer>(9));
        second.addAfter(new Node<Integer>(9), new Node<Integer>(2));

        Assert.assertEquals("1008", LinkedLists.addLists(first.head, second.head).print());
    }

    @Test
    public void testAddListsRecursive() {
        SingleLinkedList<Integer> first = new SingleLinkedList<Integer>(); //716
        first.addAfter(null, new Node<Integer>(7));
        first.addAfter(new Node<Integer>(7), new Node<Integer>(1));
        first.addAfter(new Node<Integer>(1), new Node<Integer>(6));

        SingleLinkedList<Integer> second = new SingleLinkedList<Integer>(); //295
        second.addAfter(null, new Node<Integer>(2));
        second.addAfter(new Node<Integer>(2), new Node<Integer>(9));
        second.addAfter(new Node<Integer>(9), new Node<Integer>(5));

        Assert.assertEquals("1011", LinkedLists.addListsRecursive(first.head, second.head).print());
    }

    @Test
    public void testIsPalindrome() {
        Node<Integer> head = new Node<Integer>(1);
        head.nextNode = new Node<Integer>(5);
        head.nextNode.nextNode = new Node<Integer>(6);
        head.nextNode.nextNode.nextNode = new Node<Integer>(5);
        head.nextNode.nextNode.nextNode.nextNode = new Node<Integer>(1);

        Assert.assertTrue(LinkedLists.isPalindrome(head));
    }

    @Test
    public void testReverse() {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.addAfter(null, new Node<Integer>(1));
        list.addAfter(new Node<Integer>(1), new Node<Integer>(2));
        list.addAfter(new Node<Integer>(2), new Node<Integer>(3));
        list.addAfter(new Node<Integer>(3), new Node<Integer>(2));
        list.addAfter(new Node<Integer>(3), new Node<Integer>(1));

        Assert.assertEquals("12312", list.print());
        SingleLinkedList<Integer> result = new SingleLinkedList<Integer>();
        LinkedLists.reverse(list.head, result);
        Assert.assertEquals("21321", result.print());
    }
}
