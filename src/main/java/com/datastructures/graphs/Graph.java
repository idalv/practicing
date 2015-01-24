package com.datastructures.graphs;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/24/15
 * Time: 10:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class Graph {
    private int[][] graph;
    private int counter = 1;

    public Graph(int[][] graph) {
        this.graph = graph;
    }

    private void DFS(int vertex, int visitedVertex[]) {
        // Visit the current vertex
        visitedVertex[vertex] = counter++;
        for (int i = 0; i < graph[vertex].length; i++) {
            // Get all adjacent vertices
            if (graph[vertex][i] > 0 && visitedVertex[i] == 0) {
                DFS(i, visitedVertex);
            }
        }
    }

    public int[] depthFirstSearch() {
        int visitedVertex[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visitedVertex[i] == 0) {
                DFS(i, visitedVertex);
            }
        }

        return visitedVertex;
    }


}
