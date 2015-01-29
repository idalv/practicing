package com.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/29/15
 * Time: 10:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class ShellSort {
    public static int[] sort(int[] array) {
        List<Integer> splits = calculateSplits(array.length);

        // Iterate over different number of splits
        for (int splitIndex = splits.size() - 1; splitIndex >= 0; splitIndex--) {
            int split = splits.get(splitIndex);
            // Iterate over each subarray / split
            for (int splitNumber = 0; splitNumber < split; splitNumber++) {
                // Sort the subarray consisting of following elements: array[indexInArray],
                // where indexInArray = split * [indexInSplit:0..*] + splitNumber, see page 482
                // Apply insertion sort algorithm
                for (int indexInSplit = 1, j; indexInArray(indexInSplit, split, splitNumber) < array.length; indexInSplit++) {
                    int tmp = array[indexInArray(indexInSplit, split, splitNumber)];
                    for (j = indexInSplit - 1; j >= 0 && tmp < array[indexInArray(j, split, splitNumber)]; j--) {
                        array[indexInArray(j+1, split, splitNumber)] = array[indexInArray(j, split, splitNumber)];
                    }
                    array[indexInArray(j+1, split, splitNumber)] = tmp;
                }

            }
        }

        return array;
    }

    private static List<Integer> calculateSplits(int arrayLength) {
        List<Integer> splits = new ArrayList<Integer>();
        for (int split = 1; split < arrayLength; split = 3*split + 1) {
            splits.add(split);
        }

        return splits;

    }

    private static int indexInArray(int indexInSplit, int split, int splitNumber) {
        return (split*indexInSplit)+splitNumber;
    }
}
