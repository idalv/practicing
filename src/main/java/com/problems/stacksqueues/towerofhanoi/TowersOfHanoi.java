package com.problems.stacksqueues.towerofhanoi;

import com.problems.stacksqueues.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/17/15
 * Time: 3:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class TowersOfHanoi {

    private Stack<Integer> source = new SimpleStack<Integer>();
    private int num;

    public TowersOfHanoi(int num) {
        this.num = num;
        // Put in source the numbers from num-1 to 0.
        for (int i = num - 1; i >= 0; i--) {
            source.push(i);
        }
    }

    public void move(Stack<Integer> destination) {
        Stack<Integer> buffer = new SimpleStack<Integer>();
        move(num, source, destination, buffer);
    }

    private void move(int numElements, Stack<Integer> source, Stack<Integer> destination, Stack<Integer> buffer) {
        if (numElements <= 0) {
            return;
        }
        move(numElements - 1, source, buffer, destination);
        moveTop(source, destination);
        move(numElements - 1, buffer, destination, source);
    }

    private void moveTop(Stack<Integer> source, Stack<Integer> destination) {
        if (source == null) {
            return;
        }

        destination.push(source.pop());
    }
}
