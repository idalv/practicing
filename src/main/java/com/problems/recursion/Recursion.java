package com.problems.recursion;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 3/6/15
 * Time: 6:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Recursion {
    public static int findMagic(int[] array) {
        return findMagic(array, 0, array.length - 1);
    }

    private static int findMagic(int[] array, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middle = (start + end) / 2;
        if (array[middle] == middle) {
            return middle;
        } else if (array[middle] > middle) {
            return findMagic(array, start, middle - 1);
        } else {
            return findMagic(array, middle + 1, end);
        }

    }
}
