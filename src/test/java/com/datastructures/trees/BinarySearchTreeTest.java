package com.datastructures.trees;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/14/15
 * Time: 11:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearchTreeTest {
    @Test
    public void testSearch() {
        TreeBuilder<Integer> treeBuilder = new TreeBuilder<Integer>(13);
        // Build the left tree
        treeBuilder.root().left(10).advanceLeft().left(2).right(12);
        // Build the right tree
        treeBuilder.root().right(25).advanceRight().left(20).right(31).advanceRight().left(29);

        BinarySearchTree binarySearchTree = new BinarySearchTree(treeBuilder.build());
        Node<Integer> nodeFound = binarySearchTree.search(31);

        Assert.assertNotNull(nodeFound);
        Assert.assertEquals((Integer) 31, (Integer) nodeFound.key);
    }

    @Test
    public void testSearchRecursively() {
        TreeBuilder<Integer> treeBuilder = new TreeBuilder<Integer>(13);
        // Build the left tree
        treeBuilder.root().left(10).advanceLeft().left(2).right(12);
        // Build the right tree
        treeBuilder.root().right(25).advanceRight().left(20).right(31).advanceRight().left(29);

        Node<Integer> root = treeBuilder.build();
        BinarySearchTree binarySearchTree = new BinarySearchTree(root);
        Node<Integer> nodeFound = binarySearchTree.searchRecursively(root, 31);

        Assert.assertNotNull(nodeFound);
        Assert.assertEquals((Integer) 31, (Integer) nodeFound.key);
    }
}
