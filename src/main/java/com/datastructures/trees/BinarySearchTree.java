package com.datastructures.trees;

import java.util.LinkedList;

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

    public void traverseBreadthFirst(NodeVisitor nodeVisitor) {
        if (root == null) {
            return;
        }

        LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            Node current = queue.removeFirst();
            nodeVisitor.visitNode(current);
            if (current.left != null) {
                queue.addLast(current.left);
            }
            if (current.right != null) {
                queue.addLast(current.right);
            }
        }

    }


    public void traverseDepthFirstInOrderRecursively(Node current, NodeVisitor nodeVisitor) {
        if (current == null) {
            return;
        }

        if (current.left != null) {
            traverseDepthFirstInOrderRecursively(current.left, nodeVisitor);
        }
        nodeVisitor.visitNode(current);
        if (current.right != null) {
            traverseDepthFirstInOrderRecursively(current.right, nodeVisitor);
        }
    }

    public void traverseDepthFirstPreOrder(NodeVisitor nodeVisitor) {
        if (root == null) {
            return;
        }

        LinkedList<Node<Integer>> stack = new LinkedList<Node<Integer>>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            Node current = stack.removeFirst();
            nodeVisitor.visitNode(current);
            if (current.right != null) {
                stack.addFirst(current.right);
            }
            if (current.left != null) {
                stack.addFirst(current.left);
            }
        }
    }

    public void insert(Integer key) {
        if (root == null) {
            root = new Node<Integer>(key);
            return;
        }

        Node<Integer> current = root;
        Node<Integer> prev = null;
        while (current != null) {
            prev = current;
            if (current.key == key) {
                return;
            } else if (current.key > key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (prev.key > key) {
            prev.left = new Node<Integer>(key);
        } else {
            prev.right = new Node<Integer>(key);
        }
    }
}
