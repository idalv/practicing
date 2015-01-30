package com.sorting;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/30/15
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeSort {
    public static int[] sort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(array, left, middle);
            sort(array, middle+1, right);
            merge(array, left, middle, right);
        }

        return array;
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int[] tmp = new int[right-left+1];
        int tmpIndex = 0;
        int firstArrayIndex = left;
        int secondArrayIndex = middle+1;

        while (firstArrayIndex <= middle && secondArrayIndex <= right) {
            if (array[firstArrayIndex] <= array[secondArrayIndex]) {
                tmp[tmpIndex++] = array[firstArrayIndex++];
            } else {
                tmp[tmpIndex++] = array[secondArrayIndex++];
            }
        }

        // Add the rest of the arrays
        while (firstArrayIndex <= middle) {
            tmp[tmpIndex++] = array[firstArrayIndex++];
        }

        while (secondArrayIndex <= right) {
            tmp[tmpIndex++] = array[secondArrayIndex++];
        }

        // Load the elements of tmp back in array
        for (int i = 0; left <= right; i++, left++) {
            array[left] = tmp[i];
        }
    }
}
