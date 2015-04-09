package com.problems.sortingsearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 4/7/15
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class SortingSearching {
    public static int findInRotated(int[] array, int number) {
        int rotationIndex = getRotationIndex(array);

        if (rotationIndex == -1) {
            rotationIndex = array.length / 2;
        }

        if (number == array[rotationIndex]) {
            return rotationIndex;
        }

        if (number < array[rotationIndex] && number >= array[0]) {
            return binarySearch(array, 0, rotationIndex, number);
        } else if (number >= array[rotationIndex+1] && number <= array[array.length-1]){
            return binarySearch(array,rotationIndex+1, array.length-1, number);
        }

        return -1;
    }

    private static int binarySearch(int[] array, int start, int end, int number) {
        if (start > end) {
            return -1;
        }

        int middle = (start + end) / 2;

        if (array[middle] == number) {
            return middle;
        } else if (array[middle] < number) {
            return binarySearch(array, middle+1, end, number);
        } else {
            return binarySearch(array, start, middle-1, number);
        }
    }

    private static int getRotationIndex(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1]) {
                return i;
            }
        }
        return -1;
    }
}