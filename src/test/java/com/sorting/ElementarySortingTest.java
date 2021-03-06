package com.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/28/15
 * Time: 4:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class ElementarySortingTest {
    @Test
    public void testInsertionSort() {
        Assert.assertArrayEquals(new int[] {2, 3, 5, 8, 9, 12}, ElementarySorting.insertionSort(new int[]{5, 2, 3, 9, 8, 12}));
    }

    @Test
    public void testSelectionSort() {
        Assert.assertArrayEquals(new int[] {2, 3, 5, 8, 9, 12}, ElementarySorting.selectionSort(new int[]{5, 2, 3, 9, 8, 12}));
    }

    @Test
    public void testBubbleSort() {
        Assert.assertArrayEquals(new int[] {2, 3, 5, 8, 9, 12}, ElementarySorting.bubbleSort(new int[]{5, 2, 3, 9, 8, 12}));
    }
}
