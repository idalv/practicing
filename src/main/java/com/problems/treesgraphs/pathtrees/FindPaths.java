package com.problems.treesgraphs.pathtrees;

import com.datastructures.trees.Node;
import com.datastructures.trees.TreeBuilder;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/20/15
 * Time: 4:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindPaths {
    public static void findPaths(Node<Integer> node, int sum) {
        Path path = new Path();
        findPaths(node, sum, path);
    }

    private static void findPaths(Node<Integer> node, int sum, Path path) {
        if (node == null) {
            return;
        }

        path.add(node.key);
        if (path.sum == sum) {
            path.print();
        }
        if (path.sum > sum) {
            path.remove();
        }

        Path leftPath = new Path(path);
        findPaths(node.left, sum, leftPath);

        Path rightPath = new Path(path);
        findPaths(node.right, sum, rightPath);
    }

    public static void main(String[] args) {
        TreeBuilder<Integer> treeBuilder = new TreeBuilder<Integer>(13);
        // Build the left tree
        treeBuilder.root().left(10).advanceLeft().left(2).right(12);
        // Build the right tree
        treeBuilder.root().right(4).advanceRight().left(10).right(6).advanceRight().left(2);
        Node root = treeBuilder.build();

        FindPaths.findPaths(root, 12);
    }
}
