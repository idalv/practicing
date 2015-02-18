package com.problems.stacksqueues.queuestack;

import com.problems.stacksqueues.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/18/15
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class QueueStack<T> {
    private Stack<T> enqueueStack = new SimpleStack<T>();
    private Stack<T> dequeStack = new SimpleStack<T>();

    public void enqueue(T data) {
        while (dequeStack.peek() != null) {
            enqueueStack.push(dequeStack.pop());
        }

        enqueueStack.push(data);
    }

    public T dequeue() {
        while (enqueueStack.peek() != null) {
            dequeStack.push(enqueueStack.pop());
        }

        return dequeStack.pop();
    }
}
