package com.problems.treesgraphs.nexttree;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/14/15
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class NodeWithParent<T> {
    private T key;
    private NodeWithParent<T> left;
    private NodeWithParent<T> right;
    private NodeWithParent<T> parent;

    public NodeWithParent(T key) {
        this.key = key;
    }

    public void setLeft(NodeWithParent<T> left) {
        this.left = left;
        left.setParent(this);
    }

    public void setRight(NodeWithParent<T> right) {
        this.right = right;
        right.setParent(this);
    }

    public void setParent(NodeWithParent<T> parent) {
        this.parent = parent;
    }

    public T getKey() {
        return key;
    }

    public NodeWithParent<T> getLeft() {
        return left;
    }

    public NodeWithParent<T> getRight() {
        return right;
    }

    public NodeWithParent<T> getParent() {
        return parent;
    }
}
