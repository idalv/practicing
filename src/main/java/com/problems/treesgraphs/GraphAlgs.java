package com.problems.treesgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/19/15
 * Time: 11:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class GraphAlgs {
    public static boolean hasPath(Graph graph, int vertexStart, int vertexEnd) {
        if (vertexStart == vertexEnd) {
            return true;
        }

        int[] visitedVertices = new int[graph.getAllVertices().size()];
        int visitIndex = 1;
        Queue<Integer> verticesToVisit = new LinkedList<Integer>();

        verticesToVisit.add(vertexStart);
        while (!verticesToVisit.isEmpty()) {
            Integer currentVertex = verticesToVisit.poll();
            visitedVertices[currentVertex] = visitIndex++;
            for (Integer adjacentVertex : graph.getAdjacentVertices(currentVertex)) {
                if (adjacentVertex == vertexEnd) {
                    return true;
                }
                if (visitedVertices[adjacentVertex] == 0) {
                    verticesToVisit.add(adjacentVertex);
                }
            }
        }

        return false;
    }
}
