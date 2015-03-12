package com.problems.recursion;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 3/6/15
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindRoboPath {

    public static int find(int x, int y) {
        return findPath(x, y, initPaths(x, y));
    }

    private static int[][] initPaths(int x, int y) {
        int[][] paths = new int[x+1][y+1];
        for (int i = 0; i < x+1; i++) {
            for (int j = 0; j < y+1; j++) {
                paths[i][j] = -1;
            }
        }
        return paths;
    }

    private static int findPath(int x, int y, int[][] paths) {
        if (x < 0) {
            return 0;
        }
        if (y < 0) {
            return 0;
        }
        if (x == 0 & y == 0) {
            return 0;
        }
        if (x == 0 && y == 1) {
            return 1;
        }
        if (x == 1 && y == 0) {
            return 1;
        }

        if (paths[x][y] == -1) {
            paths[x][y] = findPath(x - 1, y, paths) + findPath(x, y - 1, paths);
        }

        return paths[x][y];
    }
}
