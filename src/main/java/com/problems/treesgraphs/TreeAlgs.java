package com.problems.treesgraphs;

import com.datastructures.trees.Node;

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
}
