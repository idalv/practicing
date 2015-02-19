package com.problems.treesgraphs;

import com.datastructures.trees.Node;
import com.datastructures.trees.TreeBuilder;
import org.junit.Assert;
import org.junit.Test;

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
}
