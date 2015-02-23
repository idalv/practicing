package com.problems.treesgraphs;

import com.datastructures.trees.BinarySearchTree;
import com.datastructures.trees.Node;
import com.datastructures.trees.NodeVisitor;
import com.datastructures.trees.TreeBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/18/15
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class TreeAlgsTest {
    @Test
    public void testIsBalanced() {
        TreeBuilder<Integer> treeBuilder = new TreeBuilder<Integer>(13);
        // Build the left tree
        treeBuilder.root().left(10).advanceLeft().left(2).right(12);
        // Build the right tree
        treeBuilder.root().right(25).advanceRight().left(20).right(31).advanceRight().left(29);
        Node root = treeBuilder.build();

        TreeAlgs.IsBalancedWrapper isBalanced = TreeAlgs.isBalanced(root);
        Assert.assertTrue(isBalanced.isBalanced);
    }

    @Test
    public void testIsBalancedNegative() {
        TreeBuilder<Integer> treeBuilder = new TreeBuilder<Integer>(13);
        // Build the left tree
        treeBuilder.root().left(10);
        // Build the right tree
        treeBuilder.root().right(25).advanceRight().left(20).right(31).advanceRight().left(29);
        Node root = treeBuilder.build();

        TreeAlgs.IsBalancedWrapper isBalanced = TreeAlgs.isBalanced(root);
        Assert.assertFalse(isBalanced.isBalanced);
    }

    @Test
    public void testTraverseBreadthFirst() {
        int[] array = {0, 1, 2, 3, 4};
        Node<Integer> root = TreeAlgs.buildMinHeightBST(array, 0, 4);

        // Assert part
        BinarySearchTree binarySearchTree = new BinarySearchTree(root);
        final StringBuilder nodes = new StringBuilder();
        binarySearchTree.traverseBreadthFirst(new NodeVisitor() {
            @Override
            public void visitNode(Node node) {
                nodes.append(node.key);
            }
        });

        Assert.assertEquals("20314", nodes.toString());
    }

    @Test
    public void testDepthLists() {
        TreeBuilder<Integer> treeBuilder = new TreeBuilder<Integer>(13);
        // Build the left tree
        treeBuilder.root().left(10).advanceLeft().left(2).right(12);
        // Build the right tree
        treeBuilder.root().right(25).advanceRight().left(20).right(31).advanceRight().left(29);
        Node root = treeBuilder.build();

        List<LinkedList<Integer>> depthList = TreeAlgs.createDepthLists(root);
        Assert.assertArrayEquals(new Integer[]{13}, depthList.get(0).toArray(new Integer[]{}));
        Assert.assertArrayEquals(new Integer[]{10, 25}, depthList.get(1).toArray(new Integer[]{}));
        Assert.assertArrayEquals(new Integer[]{2, 12, 20, 31}, depthList.get(2).toArray(new Integer[]{}));
        Assert.assertArrayEquals(new Integer[]{29}, depthList.get(3).toArray(new Integer[]{}));
    }

    @Test
    public void testIsBST() {
        TreeBuilder<Integer> treeBuilder = new TreeBuilder<Integer>(13);
        // Build the left tree
        treeBuilder.root().left(10).advanceLeft().left(2).right(12);
        // Build the right tree
        treeBuilder.root().right(25).advanceRight().left(20).right(31).advanceRight().left(29);
        Node root = treeBuilder.build();

        Assert.assertTrue(TreeAlgs.isBST(root));
    }

    @Test
    public void testIsBSTPartial() {
        TreeBuilder<Integer> treeBuilder = new TreeBuilder<Integer>(13);
        // Build the left tree
        treeBuilder.root().left(10).advanceLeft().left(2).right(15);
        // Build the right tree
        treeBuilder.root().right(25).advanceRight().left(20).right(31).advanceRight().left(29);
        Node root = treeBuilder.build();

        Assert.assertFalse(TreeAlgs.isBST(root));
    }

    @Test
    public void testIsBSTNegative() {
        TreeBuilder<Integer> treeBuilder = new TreeBuilder<Integer>(13);
        // Build the left tree
        treeBuilder.root().left(10).advanceLeft().left(12).right(2);
        // Build the right tree
        treeBuilder.root().right(25).advanceRight().left(20).right(31).advanceRight().left(29);
        Node root = treeBuilder.build();

        Assert.assertFalse(TreeAlgs.isBST(root));
    }

    @Test
    public void testFindCommonParent() {
        TreeBuilder<Integer> treeBuilder = new TreeBuilder<Integer>(13);
        // Build the left tree
        treeBuilder.root().left(10).advanceLeft().left(2).right(12);
        // Build the right tree
        treeBuilder.root().right(25).advanceRight().left(20).right(31).advanceRight().left(29);
        Node root = treeBuilder.build();

        Assert.assertEquals(new Node<Integer>(25).key, TreeAlgs.findCommonParent(root, 20, 31).key);
        Assert.assertEquals(new Node<Integer>(25).key, TreeAlgs.findCommonParent(root, 20, 29).key);
        Assert.assertEquals(new Node<Integer>(25).key, TreeAlgs.findCommonParent(root, 29, 20).key);
        Assert.assertEquals(new Node<Integer>(13).key, TreeAlgs.findCommonParent(root, 2, 29).key);
        Assert.assertEquals(new Node<Integer>(25).key, TreeAlgs.findCommonParent(root, 25, 29).key);
        Assert.assertEquals(new Node<Integer>(25).key, TreeAlgs.findCommonParent(root, 29, 25).key);
    }

}
