package com.problems.treesgraphs.subtrees;

import com.datastructures.trees.Node;
import com.datastructures.trees.TreeBuilder;
import com.problems.treesgraphs.TreeAlgs;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/20/15
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class SubTreeTest {
    @Test
    public void testIsSubtree() {
        TreeBuilder<Integer> treeBuilder1 = new TreeBuilder<Integer>(13);
        // Build the left tree
        treeBuilder1.root().left(10).advanceLeft().left(12).right(2);
        // Build the right tree
        treeBuilder1.root().right(25).advanceRight().left(20).right(31).advanceRight().left(29);
        Node root1 = treeBuilder1.build();

        TreeBuilder<Integer> treeBuilder2 = new TreeBuilder<Integer>(10);
        treeBuilder2.root().left(12).right(2);
        Node root2 = treeBuilder2.build();

        Assert.assertTrue(SubTree.isSubTree(root1, root2));
    }

    @Test
    public void testIsSubtree2() {
        TreeBuilder<Integer> treeBuilder1 = new TreeBuilder<Integer>(13);
        // Build the left tree
        treeBuilder1.root().left(10).advanceLeft().left(12).right(2);
        // Build the right tree
        treeBuilder1.root().right(25).advanceRight().left(20).right(31).advanceRight().left(29);
        Node root1 = treeBuilder1.build();

        TreeBuilder<Integer> treeBuilder2 = new TreeBuilder<Integer>(13);
        // Build the left tree
        treeBuilder2.root().left(10).advanceLeft().left(12).right(2);
        // Build the right tree
        treeBuilder2.root().right(25).advanceRight().left(20).right(31).advanceRight().left(29);
        Node root2 = treeBuilder2.build();

        Assert.assertTrue(SubTree.isSubTree(root1, root2));
    }

    @Test
    public void testIsSubtreeNegative() {
        TreeBuilder<Integer> treeBuilder1 = new TreeBuilder<Integer>(13);
        // Build the left tree
        treeBuilder1.root().left(10).advanceLeft().left(12).right(2);
        // Build the right tree
        treeBuilder1.root().right(25).advanceRight().left(20).right(31).advanceRight().left(29);
        Node root1 = treeBuilder1.build();

        TreeBuilder<Integer> treeBuilder2 = new TreeBuilder<Integer>(13);
        // Build the left tree
        treeBuilder2.root().left(10).advanceLeft().left(12);
        // Build the right tree
        treeBuilder2.root().right(25).advanceRight().left(20).right(31).advanceRight().left(29);
        Node root2 = treeBuilder2.build();

        Assert.assertFalse(SubTree.isSubTree(root1, root2));
    }

    @Test
    public void testIsSubtreeNegative2() {
        TreeBuilder<Integer> treeBuilder1 = new TreeBuilder<Integer>(13);
        // Build the left tree
        treeBuilder1.root().left(10).advanceLeft().left(12).right(2);
        // Build the right tree
        treeBuilder1.root().right(25).advanceRight().left(20).right(31).advanceRight().left(29);
        Node root1 = treeBuilder1.build();

        TreeBuilder<Integer> treeBuilder2 = new TreeBuilder<Integer>(13);
        // Build the left tree
        treeBuilder2.root().left(10).advanceLeft().left(12).right(1);
        // Build the right tree
        treeBuilder2.root().right(25).advanceRight().left(20).right(31).advanceRight().left(29);
        Node root2 = treeBuilder2.build();

        Assert.assertFalse(SubTree.isSubTree(root1, root2));
    }
}
