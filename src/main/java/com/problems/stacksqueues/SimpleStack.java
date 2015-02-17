package com.problems.stacksqueues;

import com.datastructures.singlelinkedlist.Node;
/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/16/15
 * Time: 10:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleStack<T> implements Stack<T> {
    Node<T> head;
    public int length = 0;

    @Override
    public T pop() {
        if (head == null) {
            return null;
        }

        T data = head.data;
        head = head.nextNode;
        length--;
        return data;
    }

    @Override
    public void push(T data) {
        if (head == null) {
            head = new Node<T>(data);
            length++;
            return;
        }

        Node<T> node = new Node<T>(data);
        node.nextNode = head;
        head = node;
        length++;
    }

    @Override
    public T peek() {
        if (head == null) {
            return null;
        }

        return head.data;
    }

    public int length() {
        return length;
    }
}
