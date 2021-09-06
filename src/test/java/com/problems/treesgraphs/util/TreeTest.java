package com.problems.treesgraphs.util;

import org.junit.Assert;
import org.junit.Test;

import com.datastructures.trees.Node;
import com.datastructures.trees.TreeBuilder;

public class TreeTest {

  @Test
  public void testGetHeight() {
    TreeBuilder<Integer> treeBuilder = new TreeBuilder<Integer>(13);
    // Build the left tree
    treeBuilder.root().left(10).advanceLeft().left(2).right(12);
    // Build the right tree
    treeBuilder.root().right(25).advanceRight().left(20).right(31).advanceRight().left(29);
    Node root = treeBuilder.build();

    Assert.assertEquals(4, Tree.getHeight(root));
  }

}
