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
public class FindRoboPathTest {
    @Test
    public void findPath() {
        Assert.assertEquals(1, FindRoboPath.find(1, 0));
        Assert.assertEquals(1, FindRoboPath.find(0, 1));
        Assert.assertEquals(2, FindRoboPath.find(1, 1));
        Assert.assertEquals(3, FindRoboPath.find(2, 1));
        Assert.assertEquals(10, FindRoboPath.find(3, 2));
    }
}
