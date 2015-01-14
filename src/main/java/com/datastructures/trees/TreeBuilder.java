package com.datastructures.trees;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/14/15
 * Time: 11:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class TreeBuilder<T> {
    private Node<T> root;
    private Node<T> current;

    public TreeBuilder(T key) {
        this.root = new Node<T>(key);
        this.current = this.root;
    }

    public TreeBuilder left(T key) {
        current.left = new Node<T>(key);
        return this;
    }

    public TreeBuilder right(T key) {
        current.right = new Node<T>(key);
        return this;
    }

    public TreeBuilder advanceLeft() {
        current = current.left;
        return this;
    }

    public TreeBuilder advanceRight() {
        current = current.right;
        return this;
    }

    public TreeBuilder root() {
        current = root;
        return this;
    }

    public Node build() {
        return root;
    }
}
