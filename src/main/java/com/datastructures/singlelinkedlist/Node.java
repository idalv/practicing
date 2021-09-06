package com.datastructures.singlelinkedlist;

/**
 * Created with IntelliJ IDEA.
 * User: vladi
 * Date: 1/6/15
 * Time: 3:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Node<T> {
    public Node<T> nextNode;
    public T data;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Node)) {
            return false;
        }

        return this.data == ((Node<T>) other).data;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    public String print() {
        if (this == null) {
            return "";
        }

        StringBuilder list = new StringBuilder();
        for (Node<T> current = this; current != null; current = current.nextNode) {
            list.append("" + current.data);
        }

        return list.toString();
    }
}


