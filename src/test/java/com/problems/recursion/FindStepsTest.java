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
public class FindStepsTest {
    @Test
    public void findStepsIterative() {
        Assert.assertEquals(3, FindSteps.findStepsIterative(3));
        Assert.assertEquals(7, FindSteps.findStepsIterative(6));
    }

    @Test
    public void findStepsRecursive() {
        Assert.assertEquals(4, FindSteps.findStepsRecursive(3));
        Assert.assertEquals(24, FindSteps.findStepsRecursive(6));
    }

    @Test
    public void findStepsRecursiveDP() {
        Assert.assertEquals(4, FindSteps.findStepsRecursive(3));
        Assert.assertEquals(24, FindSteps.findStepsRecursive(6));
    }
}
