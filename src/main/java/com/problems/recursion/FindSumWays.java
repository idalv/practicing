package com.problems.recursion;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 3/30/15
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindSumWays {
    public static int findIteratively(int sum) {
        int ways = 0;
        for (int qNum = 0; qNum * 25 <= sum; qNum++) {
            for(int sNum = 0; qNum * 25 + sNum * 10 <= sum; sNum++) {
                for(int nNum = 0; qNum * 25 + sNum * 10 + nNum * 5 <= sum; nNum++) {
                    for (int pNum = 0; qNum * 25 + sNum * 10 + nNum * 5 + pNum <= sum; pNum++) {
                        if (qNum * 25 + sNum * 10 + nNum * 5 + pNum == sum) {
                            ways++;
                        }
                    }
                }
            }
        }
        return ways;
    }

}
