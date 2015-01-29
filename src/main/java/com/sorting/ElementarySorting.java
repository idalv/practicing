package com.sorting;

import com.util.Utilities;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/28/15
 * Time: 2:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class ElementarySorting {
    public static int[] insertionSort(int[] array) {
        for (int i = 1, j; i < array.length; i++) {
            int tmp = array[i];
            for (j = i - 1; j >= 0 && tmp < array[j]; j--) {
                array[j+1] = array[j];
            }
            array[j+1] = tmp;
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i <= array.length - 2; i++) {
            int smallestIndex = findIndexOfSmallest(array, i);
            Utilities.swap(array, i, smallestIndex);
        }

        return array;
    }

    private static int findIndexOfSmallest(int[] array, int start) {
        int smallest = Integer.MAX_VALUE;
        int smallestIndex = -1;
        for (int i = start; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = array.length-1; j > i; j--) {
                if (array[j] < array[j-1]) {
                    Utilities.swap(array, j, j - 1);
                }
            }
        }

        return array;
    }

}
