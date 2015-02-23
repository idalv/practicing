package com.problems.treesgraphs.subtrees;

import com.datastructures.trees.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/20/15
 * Time: 3:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class SubTree {
    public static boolean isSubTree(Node<Integer> rootTree, Node<Integer> rootSubTree) {
        int height = findHeight(rootSubTree);

        List<Node<Integer>> rootsList = new ArrayList<Node<Integer>>();
        findRootsAtDepth(rootTree, height, rootsList);
        for (Node<Integer> root : rootsList) {
            if (isIdentical(root, rootSubTree)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isIdentical(Node<Integer> root1, Node<Integer> root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null && root2 != null
                || root1 != null && root2 == null) {
            return false;
        }

        if (root1.key != root2.key) {
            return false;
        }

        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }

    private static int findRootsAtDepth(Node<Integer> root, int height, List<Node<Integer>> rootsList) {
        if (root == null) {
            return -1;
        }

        int currentHeight = Math.max(findRootsAtDepth(root.left, height, rootsList),
                findRootsAtDepth(root.right, height, rootsList)) + 1;

        if (height == currentHeight) {
            rootsList.add(root);
        }

        return currentHeight;
    }

    private static int findHeight(Node<Integer> root) {
        if (root == null) {
            return -1;
        }

        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }
}
