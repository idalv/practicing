package com.datastructures.trees;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/14/15
 * Time: 11:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearchTree {
    private Node<Integer> root;

    public BinarySearchTree(Node<Integer> root) {
        this.root = root;
    }

    public Node search(Integer key) {
        Node<Integer> current = root;
        while (current != null) {
            if (current.key == key) {
                return current;
            } else if (current.key > key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    public Node searchRecursively(Node<Integer> current, Integer key) {
        if (current.key == key) {
            return current;
        } else if (current.key > key) {
            return searchRecursively(current.left, key);
        } else {
            return searchRecursively(current.right, key);
        }
    }
}
