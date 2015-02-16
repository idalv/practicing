package com.problems.stacksqueues.stackofstacks;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/16/15
 * Time: 10:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class StackOfStacks<T> implements Stack<T> {
    Stack<SimpleStack<T>> stackOfStacks = new SimpleStack<SimpleStack<T>>();
    private int MAX_LENGTH = 5;

    @Override
    public T pop() {
        Stack<T> current = stackOfStacks.peek();
        if (current == null) {
            return null;
        }

        T data = current.pop();
        if (stackOfStacks.peek().length() == 0) {
            stackOfStacks.pop();
        }
        return data;
    }

    @Override
    public void push(T i) {
        SimpleStack<T> current = stackOfStacks.peek();
        if (current == null || current.length() == MAX_LENGTH) {
            current = new SimpleStack<T>();
            stackOfStacks.push(current);
        }

        current.push(i);
    }

    @Override
    public T peek() {
        Stack<T> current = stackOfStacks.peek();
        if (current == null) {
            return null;
        }

        return current.peek();
    }
}
