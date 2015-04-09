package com.problems.sortingsearching;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 3/6/15
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class TowerTest {
    @Test
    public void buildTower() {
        Deque<Tower.Pair> result = Tower.buildTower(new Tower.Pair[]{
                new Tower.Pair(65, 100), new Tower.Pair(75, 150),
                new Tower.Pair(56, 90), new Tower.Pair(75, 190),
                new Tower.Pair(60, 95), new Tower.Pair(68, 110)});
        Assert.assertEquals(6, result.size());
    }

    @Test
    public void buildTower2() {
        Deque<Tower.Pair> result = Tower.buildTower(new Tower.Pair[]{
                new Tower.Pair(68, 100), new Tower.Pair(75, 150),
                new Tower.Pair(56, 90), new Tower.Pair(75, 190),
                new Tower.Pair(60, 95), new Tower.Pair(65, 110)});
        Assert.assertEquals(5, result.size());
    }

    @Test
    public void buildTower3() {
        Deque<Tower.Pair> result = Tower.buildTower(new Tower.Pair[]{
                new Tower.Pair(62, 100), new Tower.Pair(75, 150),
                new Tower.Pair(56, 90), new Tower.Pair(75, 190),
                new Tower.Pair(63, 95), new Tower.Pair(65, 110)});
        Assert.assertEquals(5, result.size());
    }
}
