package com.problems.treesgraphs;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/19/15
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class Graph {
    private Map<Integer, List<Integer>> adjacencyList = new HashMap<Integer, List<Integer>>();

    public void addAdjacentVertex(int vertex, int adjacentVertex) {
        // Add an edge
        List<Integer> adjacentVertices = adjacencyList.get(vertex);
        if (adjacentVertices == null) {
            adjacentVertices = new LinkedList<Integer>();
            adjacencyList.put(vertex, adjacentVertices);
        }
        adjacentVertices.add(adjacentVertex);

        // Add the adjacent vertex as a node only too
        if (!adjacencyList.containsKey(adjacentVertex)) {
            adjacencyList.put(adjacentVertex, new LinkedList<Integer>());
        }
    }

    public List<Integer> getAdjacentVertices(int vertex) {
        return adjacencyList.get(vertex);
    }

    public Set<Integer> getAllVertices() {
        return adjacencyList.keySet();
    }
}
