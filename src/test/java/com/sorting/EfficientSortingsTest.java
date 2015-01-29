package com.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/29/15
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class EfficientSortingsTest {
    @Test
    public void testShellSort() {
        Assert.assertArrayEquals(new int[]{2, 3, 5, 8, 9, 12}, ShellSort.sort(new int[]{5, 2, 3, 9, 8, 12}));
    }

    @Test
    public void testShellSort2() {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 5, 8, 9, 11, 12, 17, 33, 65, 101},
                ShellSort.sort(new int[]{2, 3, 5, 8, 9, 12, 1, 65, 11, 33, 101, 17}));
    }
}
