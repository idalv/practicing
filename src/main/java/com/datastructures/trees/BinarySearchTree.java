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

    public void deleteByMerging(Integer key) {
        if (root == null) {
            return;
        }

        Node<Integer> current = root;
        Node<Integer> prev = null;
        while (current != null) {
            if (current.key == key) {
                break;
            } else if (current.key > key) {
                prev = current;
                current = current.left;
            }  else {
                prev = current;
                current = current.right;
            }
        }

        if (current == null) {
            // Node not found. Nothing will be deleted
            return;
        }

        Node<Integer> newRoot = null;
        if (current.left == null) {
            newRoot = current.right;
        } else if (current.right == null) {
            newRoot = current.left;
        } else {
            // Now the more complex case. The node to be deleted has both children
            // The new root to be attached will be the left tree's root
            newRoot = current.left;
            // Find the biggest key from the left tree (the rightest one)
            Node currLeft = current.left;
            while (currLeft.right != null) {
                currLeft = currLeft.right;
            }
            // Attach the right tree as a right child of the node found
            currLeft.right = current.right;
        }

        if (current == root) {
            root = newRoot;
        } else if (prev.left == current) {
            prev.left = newRoot;
        } else {
            prev.right = newRoot;
        }
    }

    public void deleteByCopying(Integer key) {
        if (root == null) {
            return;
        }

        Node<Integer> current = root;
        Node<Integer> prev = null;
        while (current != null) {
            if (current.key == key) {
                break;
            } else if (current.key > key) {
                prev = current;
                current = current.left;
            }  else {
                prev = current;
                current = current.right;
            }
        }

        if (current == null) {
            // Node not found. Nothing will be deleted
            return;
        }

        Node<Integer> newRoot = null;
        if (current.left == null) {
            newRoot = current.right;
        } else if (current.right == null) {
            newRoot = current.left;
        } else {
            // Now the more complex case. The node to be deleted has both children
            // Find the biggest key from the left tree (the rightest one)
            Node<Integer> currLeft = current.left;
            Node previous = current;
            while (currLeft.right != null) {
                previous = currLeft;
                currLeft = currLeft.right;
            }
            // Assign the key of the found node to the node that should be deleted
            current.key =  currLeft.key;
            // Node delete the new node
            if (previous == current) {
                previous.left = currLeft.left;
            } else {
                previous.right = currLeft.left;
            }
            // The new root to be attached is still the current one. It has new value now
            newRoot = current;
        }

        if (current == root) {
            root = newRoot;
        } else if (prev.left == current) {
            prev.left = newRoot;
        } else {
            prev.right = newRoot;
        }
    }
}
