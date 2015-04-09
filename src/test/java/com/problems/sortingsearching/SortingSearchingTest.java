package com.problems.sortingsearching;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 3/6/15
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class SortingSearchingTest {
    @Test
    public void findInRotated() {
        Assert.assertEquals(8, SortingSearching.findInRotated(new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 5));
    }

    @Test
    public void findInRotated2() {
        Assert.assertEquals(2, SortingSearching.findInRotated(new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 19));
    }
}
