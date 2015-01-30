package com.sorting;

import com.util.Utilities;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/30/15
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class QuickSort {

    public static int[] sort(int[] array) {
        if (array.length < 2) {
            return array;
        }

        // We might go with this approach and remove the check l < right
//        int max = 0;
//        // Find the largest element and put it at the end
//        for (int i = 0; i < array.length; i++) {
//            if (array[max] < array[i]) {
//                max = i;
//            }
//        }
//        Utilities.swap(array, max, array.length-1);
        sort(array, 0, array.length-1);
        return array;
    }

    public static void sort(int[] array, int left, int right) {
        int boundaryIndex = (left + right) / 2; //NB! It is not (right-left)/2
        int boundary = array[boundaryIndex];

        // Put the boundary in front (to the left)
        Utilities.swap(array, left, boundaryIndex);
        int l = left+1;
        int r = right;

        while (l <= r) {
            while (array[l] < boundary && l < right) l++;    //NB! l < right is mandatory otherwise we need to put the max element to the end
            while (array[r] > boundary && r > left) r--;

            if (l < r) {
                Utilities.swap(array, l++, r--);   //NB! swap AND PROCEED
            } else {
                break;
            }
        }
        // Return the boundary
        Utilities.swap(array, left, r);

        if (left < r-1) sort(array, left, r-1);    // NB! the boundary stays. That is why we have r-1 and r+1
        if (r+1 < right) sort(array, r+1, right);
    }
}
