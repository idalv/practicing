package com.datastructures.graphs;

import java.util.LinkedList;

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

    public int[] breadthFirstSearch() {
        int visitedVertex[] = new int[graph.length];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int counter = 1;
        for (int i = 0; i < graph.length; i++) {
            if (visitedVertex[i] == 0) {
                visitedVertex[i] = counter++;
                queue.addLast(i);
                while (!queue.isEmpty()) {
                    int current = queue.removeFirst();
                    for (int j = 0; j < graph[current].length; j++) {
                        if (graph[current][j] > 0 && visitedVertex[j] == 0) {
                            visitedVertex[j] = counter++;
                            queue.addLast(j);
                        }
                    }
                }
            }
        }

        return visitedVertex;
    }


}
