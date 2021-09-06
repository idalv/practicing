package com.problems.treesgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.datastructures.trees.Node;
import com.problems.treesgraphs.util.Tree;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/18/15
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class TreeAlgs {

    public static class IsBalancedWrapper {
        public boolean isBalanced = true;
        public int height = 0;
    }

    public static <T> IsBalancedWrapper isBalanced(Node<T> treeRoot) {
        if (treeRoot == null) {
            return new IsBalancedWrapper();
        }
        IsBalancedWrapper leftTree = isBalanced(treeRoot.left);
        IsBalancedWrapper rightTree = isBalanced(treeRoot.right);

        IsBalancedWrapper current =  new TreeAlgs.IsBalancedWrapper();
        current.height = Math.max(leftTree.height, rightTree.height) + 1;
        current.isBalanced = leftTree.isBalanced && rightTree.isBalanced
                && Math.abs(leftTree.height - rightTree.height) <= 1;
        return current;
    }

    public static <T> boolean isBalanced2(Node<T> treeRoot) {
        if (treeRoot == null) {
            return true;
        }
        return Math.abs(Tree.getHeight(treeRoot.left) - Tree.getHeight(treeRoot.right)) <= 1
            && isBalanced2(treeRoot.left)
            && isBalanced2(treeRoot.right);
    }

    public static Node<Integer> buildMinHeightBST(int[] array, int start, int end) {
        int middleIndex = (start + end) / 2;
        Node<Integer> node = new Node<Integer>(array[middleIndex]);
        if (middleIndex - 1 >= start) {
            node.left = buildMinHeightBST(array, start, middleIndex - 1);
        }
        if (middleIndex + 1 <= end) {
            node.right = buildMinHeightBST(array, middleIndex + 1, end);
        }
        return node;
    }

    public static List<LinkedList<Integer>> createDepthLists(Node<Integer> root) {
        List<LinkedList<Integer>> depthLists = new ArrayList<LinkedList<Integer>>();
        fillListsAtDepth(root, depthLists, 0);
        return depthLists;
    }

    private static void fillListsAtDepth(Node<Integer> node, List<LinkedList<Integer>> depthLists, int depth) {
        if (depthLists.size() <= depth || depthLists.get(depth) == null) {
            depthLists.add(depth, new LinkedList<Integer>());
        }
        LinkedList<Integer> depthList = depthLists.get(depth);
        depthList.add(node.key);

        if (node.left != null) {
            fillListsAtDepth(node.left, depthLists, depth + 1);
        }
        if (node.right != null) {
            fillListsAtDepth(node.right, depthLists, depth + 1);
        }
    }

    public static boolean isBST(Node<Integer> node) {
        return isBST(node.left, Integer.MIN_VALUE, node.key)
                && isBST(node.right, node.key, Integer.MAX_VALUE);
    }

    private static boolean isBST(Node<Integer> node, Integer minValue, Integer maxValue) {
        if (node == null) {
            return true;
        }

        return minValue < node.key && maxValue >= node.key
                && isBST(node.left, minValue, node.key)
                && isBST(node.right, node.key, maxValue);
    }

    public static Node<Integer> findCommonParent(Node<Integer> root, int node1, int node2) {
        if (root == null) {
            return null;
        }

        if (root.left == null) {
            return findCommonParent(root.right, node1, node2);
        }

        if (root.right == null) {
            return findCommonParent(root.left, node1, node2);
        }

        if (root.key == node1 || root.key == node2) {
            return root;
        }

        if (root.left.key == node1 && root.right.key == node2) {
            return root;
        }

        boolean leftContains1 = contains(root.left, node1);
        boolean rightContains2 = contains(root.right, node2);
        if (leftContains1 == rightContains2) {
            return root;
        }

        if (leftContains1 && !rightContains2) {
            return findCommonParent(root.left, node1, node2);
        } else {
            return findCommonParent(root.right, node1, node2);
        }
    }

    private static boolean contains(Node<Integer> root, int node) {
        if (root == null) {
            return false;
        }

        if (root.key == node) {
            return true;
        }

        return contains(root.left, node) || contains(root.right, node);
    }
}
