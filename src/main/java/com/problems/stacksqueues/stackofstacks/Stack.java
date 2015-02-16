package com.problems.stacksqueues.stackofstacks;

import com.datastructures.singlelinkedlist.Node;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/16/15
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Stack<T> {
    T pop();
    void push(T i);
    T peek();
}
