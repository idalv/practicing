package com.problems.recursion;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

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
        Assert.assertEquals(-1, Recursion.findMagic(new int[]{-3, -1, 0, 2, 5}));
    }

    @Test
    public void findSubsets() {
        System.out.println(Recursion.findSubSets(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void findPermutations() {
        Assert.assertEquals(Arrays.asList("cba", "bca", "bac", "cab", "acb", "abc"),
                Recursion.findPermutations("abc"));
    }

    @Test
    public void fillArea() {
        int[][] area = {{1, 1, 2}, {2, 1, 2}, {2, 2, 1}};
        Recursion.fillArea(area, 1, 1, 3);
        System.out.print("{");
        for (int j = 0; j < area.length; j++) {
            System.out.print("{");
            for (int i = 0; i < area[j].length; i++) {
                System.out.print(area[j][i]);
            }
            System.out.print("}");
        }
        System.out.println("}");
    }

    @Test
    public void findTallest() {
        List<Recursion.Box> boxes = Arrays.asList(new Recursion.Box(7, 8, 6),
                new Recursion.Box(10, 7, 12), new Recursion.Box(5, 5, 4));
        Deque<Recursion.Box> tallest = Recursion.buildTallest(boxes);

        Assert.assertArrayEquals(new Recursion.Box[] {new Recursion.Box(10, 7, 12), new Recursion.Box(5, 5, 4)},
                tallest.toArray(new Recursion.Box[]{}));
    }

    @Test
    public void findTallest2() {
        List<Recursion.Box> boxes = Arrays.asList(new Recursion.Box(7, 8, 6),
                new Recursion.Box(10, 7, 2), new Recursion.Box(5, 5, 4));
        Deque<Recursion.Box> tallest = Recursion.buildTallest(boxes);

        Assert.assertArrayEquals(new Recursion.Box[] {new Recursion.Box(7, 8, 6), new Recursion.Box(5, 5, 4)},
                tallest.toArray(new Recursion.Box[]{}));
    }

    @Test
    public void findTallest3() {
        List<Recursion.Box> boxes = Arrays.asList(new Recursion.Box(4, 8, 15),
                new Recursion.Box(10, 7, 12), new Recursion.Box(5, 5, 4));
        Deque<Recursion.Box> tallest = Recursion.buildTallest(boxes);

        Assert.assertArrayEquals(new Recursion.Box[] {new Recursion.Box(10, 7, 12), new Recursion.Box(5, 5, 4)},
                tallest.toArray(new Recursion.Box[]{}));
    }

    @Test
    public void findTallest4() {
        List<Recursion.Box> boxes = Arrays.asList(new Recursion.Box(4, 8, 16),
                new Recursion.Box(10, 7, 11), new Recursion.Box(5, 5, 4));
        Deque<Recursion.Box> tallest = Recursion.buildTallest(boxes);

        Assert.assertArrayEquals(new Recursion.Box[] {new Recursion.Box(4, 8, 16)},
                tallest.toArray(new Recursion.Box[]{}));
    }

    @Test
    public void getLongestAscSubsequence() {
        Assert.assertArrayEquals(new Integer[] {10, 11, 12},
                Recursion.getLongestAscSubsequence(new int[] {13, 14, 10, 11, 12}).toArray(new Integer[]{}));
    }

    @Test
    public void getLongestAscSubsequence2() {
        Assert.assertArrayEquals(new Integer[] {13, 14, 15},
                Recursion.getLongestAscSubsequence(new int[] {13, 14, 10, 15, 12}).toArray(new Integer[]{}));
    }
}
