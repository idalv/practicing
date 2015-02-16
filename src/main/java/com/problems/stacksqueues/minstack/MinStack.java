package com.problems.stacksqueues.minstack;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/16/15
 * Time: 9:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class MinStack {
    private MinNode head;

    public void push(Integer data) {
        if (head == null) {
            head = new MinNode(data, data);
        }

        MinNode node = new MinNode(data, (data < head.min) ? data : head.min, head);
        head = node;
    }

    public Integer pop() {
        if (head == null) {
            return null;
        }

        MinNode node = head;
        head = head.nextNode;
        return node.data;
    }

    public Integer min() {
        if (head == null) {
            return null;
        }

        return head.min;
    }
}
