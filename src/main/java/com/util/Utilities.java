package com.util;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/29/15
 * Time: 2:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class Utilities {
    public static void swap(int[] array, int first, int second) {
        int tmp = array[second];
        array[second] = array[first];
        array[first] = tmp;
    }

    public static<T> void swap(List<T> array, int first, int second) {
        T tmp = array.get(second);
        array.add(second, array.get(first));
        array.add(first, tmp);
    }
}
