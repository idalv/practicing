package com.problems.treesgraphs.util;

import com.datastructures.trees.Node;

public class Tree {

  public static <T> int getHeight(Node<T> treeRoot) {
    if (treeRoot == null) {
      return 0;
    }

    return 1 + Math.max(getHeight(treeRoot.left), getHeight(treeRoot.right));
  }
}
