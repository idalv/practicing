package com.datastructures.sorting;

import com.sorting.InsertionSort;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/28/15
 * Time: 4:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class InsertionSortTest {
    @Test
    public void testInsertionSort() {
        Assert.assertArrayEquals(new int[] {2, 3, 5, 8, 9, 12}, InsertionSort.sort(new int[] {5, 2, 3, 9, 8, 12}));
    }
}
