package com.problems.treesgraphs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/19/15
 * Time: 12:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class GraphAlgsTest {
    @Test
    public void testHasPath() {
        Graph graph = new Graph();
        graph.addAdjacentVertex(0, 1);
        graph.addAdjacentVertex(1, 3);
        graph.addAdjacentVertex(1, 5);
        graph.addAdjacentVertex(1, 2);
        graph.addAdjacentVertex(2, 4);

        Assert.assertTrue(GraphAlgs.hasPath(graph, 0, 4));
    }

    @Test
    public void testHasPathNegative() {
        Graph graph = new Graph();
        graph.addAdjacentVertex(0, 1);
        graph.addAdjacentVertex(1, 3);
        graph.addAdjacentVertex(1, 5);
        graph.addAdjacentVertex(2, 4);

        Assert.assertFalse(GraphAlgs.hasPath(graph, 0, 4));
    }
}
