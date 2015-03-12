package com.problems.recursion;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 3/6/15
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class RecursionTest {
    @Test
    public void findMagic() {
        Assert.assertEquals(2, Recursion.findMagic(new int[]{-3, -1, 2, 5}));
        Assert.assertEquals(2, Recursion.findMagic(new int[]{-3, -1, 0, 2, 5}));
    }
}
