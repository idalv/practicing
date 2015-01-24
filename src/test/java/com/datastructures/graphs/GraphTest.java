package com.datastructures.graphs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/24/15
 * Time: 11:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class GraphTest {
    static int[][] graph = {{0, 0, 0, 0, 1, 1, 1, 0, 1},
            {0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 8},
            {1, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 1, 0, 0, 0}};

    @Test
    public void testDepthFirstSearch() {
        Graph graph = new Graph(GraphTest.graph);
        int[] visitedVertex = graph.depthFirstSearch();

        Assert.assertArrayEquals(new int[] {1, 6, 7, 9, 2, 3, 5, 8, 4}, visitedVertex);
    }

    @Test
    public void testBreadthFirstSearch() {
        Graph graph = new Graph(GraphTest.graph);
        int[] visitedVertex = graph.breadthFirstSearch();

        Assert.assertArrayEquals(new int[] {1, 6, 7, 9, 2, 3, 4, 8, 5}, visitedVertex);
    }
}
