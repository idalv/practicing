package com.datastructures.trees;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/14/15
 * Time: 11:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearchTreeTest {
    public static Node<Integer> root;

    @BeforeClass
    public static void buildTree() {
        TreeBuilder<Integer> treeBuilder = new TreeBuilder<Integer>(13);
        // Build the left tree
        treeBuilder.root().left(10).advanceLeft().left(2).right(12);
        // Build the right tree
        treeBuilder.root().right(25).advanceRight().left(20).right(31).advanceRight().left(29);

        root = treeBuilder.build();
    }


    @Test
    public void testSearch() {
        BinarySearchTree binarySearchTree = new BinarySearchTree(root);
        Node<Integer> nodeFound = binarySearchTree.search(31);

        Assert.assertNotNull(nodeFound);
        Assert.assertEquals((Integer) 31, (Integer) nodeFound.key);
    }

    @Test
    public void testSearchRecursively() {
        BinarySearchTree binarySearchTree = new BinarySearchTree(root);
        Node<Integer> current = root;
        Node<Integer> nodeFound = binarySearchTree.searchRecursively(current, 31);

        Assert.assertNotNull(nodeFound);
        Assert.assertEquals((Integer) 31, (Integer) nodeFound.key);
    }

    @Test
    public void testTraverseBreadthFirst() {
        BinarySearchTree binarySearchTree = new BinarySearchTree(root);
        final StringBuilder nodes = new StringBuilder();
        binarySearchTree.traverseBreadthFirst(new NodeVisitor() {
            @Override
            public void visitNode(Node node) {
                nodes.append(node.key);
            }
        });

        Assert.assertEquals("131025212203129", nodes.toString());
    }

    @Test
    public void testTraverseDepthFirstInOrderRecursively() {
        BinarySearchTree binarySearchTree = new BinarySearchTree(root);
        final StringBuilder nodes = new StringBuilder();
        Node current = root;
        binarySearchTree.traverseDepthFirstInOrderRecursively(current, new NodeVisitor() {
            @Override
            public void visitNode(Node node) {
                nodes.append(node.key);
            }
        });

        Assert.assertEquals("210121320252931", nodes.toString());
    }

    @Test
    public void testTraverseDepthFirstPreOrder() {
        BinarySearchTree binarySearchTree = new BinarySearchTree(root);
        final StringBuilder nodes = new StringBuilder();
        binarySearchTree.traverseDepthFirstPreOrder(new NodeVisitor() {
            @Override
            public void visitNode(Node node) {
                nodes.append(node.key);
            }
        });

        Assert.assertEquals("131021225203129", nodes.toString());
    }
}
