package com.problems.sortingsearching;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 4/8/15
 * Time: 5:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tower {
    private static Deque<Pair> tallest = new LinkedList<>();

    public static class Pair implements Comparable<Pair> {
        int height;
        int weight;

        public Pair(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static Deque<Pair> buildTower(Pair[] pairs) {
        // Order the pairs by weight
        Arrays.sort(pairs);
        // Now iterate through the pairs and build the tallest tower
        buildTower(pairs, 0, new LinkedList<Pair>());
        return tallest;
    }

    private static void buildTower(Pair[] pairs, int fromIndex, Deque<Pair> currentTower) {
        for (int i = fromIndex; i < pairs.length; i++) {
            if (currentTower.isEmpty() || currentTower.getLast().height <= pairs[i].height) {
                currentTower.addLast(pairs[i]);
                buildTower(pairs, i+1, currentTower);
            }
        }

        if (currentTower.size() > tallest.size()) {
            tallest = new LinkedList<>();
            tallest.addAll(currentTower);
        }

        if (!currentTower.isEmpty()) {
            currentTower.removeLast();
        }
    }

}
