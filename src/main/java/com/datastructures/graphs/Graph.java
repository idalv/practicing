package com.datastructures.graphs;

import java.util.*;

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

    public int[] dijkstra(int first) {
        int[] currentDist = initializeCurrentDist(first);
        int[] predecessor = new int[graph.length];

        Map<Integer, Integer> toBeChecked = initializeToBeChecked(first);
        while (!toBeChecked.isEmpty()) {
            int current = getNextMin(toBeChecked);
            toBeChecked.remove(current);

            for (int j = 0; j < graph[current].length; j++) {
                if (graph[current][j] > 0) {
                    int newDist = currentDist[current] + graph[current][j];

                    if (currentDist[j] > newDist) {
                        currentDist[j] = newDist;
                        predecessor[j] = current;
                        toBeChecked.put(j, newDist);
                    }
                }
            }
        }

        return currentDist;

    }

    private Map<Integer, Integer> initializeToBeChecked(int first) {
        Map<Integer, Integer> vertexDist = new HashMap<Integer, Integer>();

        for (int i = 0; i < graph.length; i++) {
            int distance = (first == i) ? 0 : Integer.MAX_VALUE;
            vertexDist.put(i, distance);
        }

        return vertexDist;
    }

    private int getNextMin(Map<Integer, Integer> toBeChecked) {
        int vertexIndex = -1;
        int vertexDist = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> vertex : toBeChecked.entrySet()) {
            if (vertex.getValue() < vertexDist) {
                vertexIndex = vertex.getKey();
                vertexDist = vertex.getValue();
            }
        }

        return vertexIndex;
    }

    private int[] initializeCurrentDist(int first) {
        int[] currentDist = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (first == i) {
                currentDist[i] = 0;
            } else {
                currentDist[i] = Integer.MAX_VALUE;
            }
        }
        return  currentDist;
    }


}
