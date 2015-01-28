package com.sorting;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/28/15
 * Time: 2:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class InsertionSort {
    public static int[] sort(int[] array) {
        for (int i = 1, j; i < array.length; i++) {
            int tmp = array[i];
            for (j = i - 1; j >= 0 && tmp < array[j]; j--) {
                array[j+1] = array[j];
            }
            array[j+1] = tmp;
        }
        return array;
    }
}
