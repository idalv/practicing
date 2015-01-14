package com.datastructures.trees;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/14/15
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class Node<T> {
    public T key;
    public Node<T> left;
    public Node<T> right;

    public Node(T key) {
        this.key = key;
    }

    public Node(T key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}
