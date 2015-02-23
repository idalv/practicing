package com.problems.treesgraphs.nexttree;

/**
 * Created with IntelliJ IDEA.  FindNext
 * User: Vladimir Mitev
 * Date: 2/20/15
 * Time: 11:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class NextInTree {
    public static NodeWithParent findNext(NodeWithParent<Integer> node) {
        if (node.getRight() == null) {
            return firstBiggerParent(node);
        }

        return minNode(node.getRight());
    }

    private static NodeWithParent minNode(NodeWithParent<Integer> root) {
        NodeWithParent<Integer> minNode = root;
        while (minNode.getLeft() != null) minNode = minNode.getLeft();
        return minNode;
    }

    private static NodeWithParent firstBiggerParent(NodeWithParent<Integer> node) {
        while (node.getParent() != null && node.getKey() > node.getParent().getKey()) node = node.getParent();
        return node.getParent();
    }
}
