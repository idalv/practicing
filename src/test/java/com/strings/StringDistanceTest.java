package com.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/6/15
 * Time: 4:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringDistanceTest {
    @Test
    public void testComputeDistance() {
        String source = "capital";
        String target = "apple";
        int[][] dist = StringDistance.computeDistance(source, target);
        Assert.assertEquals(5, dist[source.length()][target.length()]);
    }

    @Test
    public void testComputeAlignment() {
        String source = "capital";
        String target = "apple";
        String alignment = StringDistance.computeAlignment(source, target);
        Assert.assertEquals("capital\n-apple-", alignment);
    }
}
