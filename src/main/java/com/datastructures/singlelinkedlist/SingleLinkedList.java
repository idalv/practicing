package com.datastructures.singlelinkedlist;

/**
 * Created with IntelliJ IDEA.
 * User: vladi
 * Date: 1/6/15
 * Time: 4:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class SingleLinkedList<T> {
    private Node<T> head;

    public SingleLinkedList() {
        head = null;
    }

    public void addAfter(Node<T> afterNode, Node<T> node) {
        if (node == null) {
            return;
        }

        if (head == null) {
            head = node;
            return;
        }

        Node<T> current = head;
        while (current != null && !current.equals(afterNode)) {
            current = current.nextNode;
        }

        if (current == null) {
            return;
        }

        node.nextNode = current.nextNode;
        current.nextNode = node;
    }

    public void addBefore(Node<T> beforeNode, Node<T> node) {
        if (node == null) {
            return;
        }

        if (head == null) {
            head = node;
            return;
        }

        if (beforeNode.equals(head)) {
            node.nextNode = head;
            head = node;
            return;
        }

        Node<T> current = head;
        while (current.nextNode != null && !current.nextNode.equals(beforeNode)) {
            current = current.nextNode;
        }

        if (current.nextNode == null) {
            return;
        }

        node.nextNode = current.nextNode;
        current.nextNode = node;
    }

    public void delete(Node<T> node) {
        if (node == null || head == null) {
            return;
        }

        if (head.equals(node)) {
            head = head.nextNode;
            return;
        }

        Node<T> current = head;
        while (current.nextNode != null && !current.nextNode.equals(node)) {
            current = current.nextNode;
        }

        if (current.nextNode == null) {
            return;
        }

        current.nextNode = current.nextNode.nextNode;
    }

    public boolean contains(Node<T> node) {
        if (node == null || head == null) {
            return false;
        }

        for (Node<T> current = head; current != null; current = current.nextNode) {
            if (current.equals(node)) {
                return true;
            }
        }

        return false;
    }

    public String print() {
        if (head == null) {
            return "";
        }

        StringBuilder list = new StringBuilder();
        for (Node<T> current = head; current != null; current = current.nextNode) {
            list.append("" + current.data);
        }

        return list.toString();
    }


}
