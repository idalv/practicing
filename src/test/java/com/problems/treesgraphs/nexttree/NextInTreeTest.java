package com.problems.treesgraphs.nexttree;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/20/15
 * Time: 12:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class NextInTreeTest {
    @Test
    public void testIsBST() {
        NodeWithParent<Integer> root = new NodeWithParent<Integer>(16);
        NodeWithParent<Integer> node13 = new NodeWithParent<Integer>(13);
        NodeWithParent<Integer> node23 = new NodeWithParent<Integer>(23);
        NodeWithParent<Integer> node5 = new NodeWithParent<Integer>(5);
        NodeWithParent<Integer> node15 = new NodeWithParent<Integer>(15);
        NodeWithParent<Integer> node17 = new NodeWithParent<Integer>(17);
        NodeWithParent<Integer> node26 = new NodeWithParent<Integer>(26);
        NodeWithParent<Integer> node14 = new NodeWithParent<Integer>(14);
        root.setLeft(node13);
        root.setRight(node23);
        node13.setLeft(node5);
        node13.setRight(node15);
        node23.setLeft(node17);
        node23.setRight(node26);
        node15.setLeft(node14);

        Assert.assertEquals(node15, NextInTree.findNext(node14));
        Assert.assertEquals(root, NextInTree.findNext(node15));
        Assert.assertEquals(node23, NextInTree.findNext(node17));
        Assert.assertEquals(node17, NextInTree.findNext(root));
    }
}
