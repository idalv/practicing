package com.problems.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 3/6/15
 * Time: 10:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class FindSteps {
    public static int findStepsIterative(int n) {
        int count = 0;
        for (int threes = 0; threes * 3 <= n; threes++) {
            for (int twos = 0; twos * 2 + threes * 3 <= n; twos++) {
                // the rest of the sum could be filled with 1s
                count++;
            }
        }
        return count;
    }

    public static int findStepsRecursive(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return findStepsRecursive(n-1) + findStepsRecursive(n-2) + findStepsRecursive(n-3);
    }

    static List<Integer> tmp = new ArrayList<Integer>();

    public static int findStepsRecursiveDP(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (tmp.get(n) != null) {
            return tmp.get(n);
        } else {
            tmp.add(n, findStepsRecursive(n-1) + findStepsRecursive(n-2) + findStepsRecursive(n-3));
            return tmp.get(n);
        }
    }


}
