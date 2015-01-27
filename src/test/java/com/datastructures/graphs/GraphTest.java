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

    static int[][] weightedGraph = {{0, 0, 0, 0, 1, 0, 0, 10, 0, 0},
            {0, 0, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {4, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
            {0, 1, 3, 0, 0, 0, 7, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 5, 0, 0, 0, 9, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0}};

    static int[][] cycleGraphNegative = {{0, 1, 2},
            {1, 0, 0},
            {1, 0, 0}};

    static int[][] cycleGraphPositive = {{0, 1, 2, 0, 0, 0},
            {1, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 1, 0}};

    static int[][] digraph = {{0, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}};

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

    @Test
    public void testDijkstra() {
        Graph graph = new Graph(GraphTest.weightedGraph);
        int[] shortestDist = graph.dijkstra(3);

        Assert.assertArrayEquals(new int[] {4, 9, 11, 0, 5, 8, 12, 1, 9, 11}, shortestDist);
    }

    @Test
    public void testCycleDetectorNegative() {
        Graph graph = new Graph(GraphTest.cycleGraphNegative);
        Assert.assertFalse(graph.cycleDetector());
    }

    @Test
    public void testCycleDetectorPositive() {
        Graph graph = new Graph(GraphTest.cycleGraphPositive);
        Assert.assertTrue(graph.cycleDetector());
    }

    @Test
    public void testConnectivityDetectorNegative() {
        Graph graph = new Graph(GraphTest.cycleGraphPositive);
        Assert.assertFalse(graph.connectivityDetector());
    }

    @Test
    public void testConnectivityDetectorPositive() {
        Graph graph = new Graph(GraphTest.cycleGraphNegative);
        Assert.assertTrue(graph.connectivityDetector());
    }

    @Test
    public void testTopologicalSorting() {
        Graph graph = new Graph(GraphTest.digraph);
        Assert.assertArrayEquals(new int[] {7, 3, 6, 5, 2, 4, 1}, graph.topologicalSearch());
    }
}
