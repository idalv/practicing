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
public class FindSumWaysTest {
    @Test
    public void findStepsIterative() {
        Assert.assertEquals(1, FindSumWays.findIteratively(1));
        Assert.assertEquals(2, FindSumWays.findIteratively(5));
        Assert.assertEquals(4, FindSumWays.findIteratively(10));
    }
}
