package com.problems.arraysstrings;

import com.problems.arraysstrings.ArraysStrings;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/11/15
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class ArrayStringsTest {
    @Test
    public void testUniqueCharacters() {
        Assert.assertTrue(ArraysStrings.uniqueCharacters("aLbmkr"));
    }

    @Test
    public void testUniqueCharactersNegative() {
        Assert.assertFalse(ArraysStrings.uniqueCharacters("Aaide"));
    }

    @Test
    public void testReverse() {
        Assert.assertEquals("esreveR", ArraysStrings.reverse("Reverse"));
    }

    @Test
    public void testReplaceEmpty() {
        Assert.assertEquals("Mr.%20John%20Smith", ArraysStrings.replaceEmpty("Mr. John Smith    ", 14));
    }

    @Test
    public void testIsRotationSimple() {
        Assert.assertTrue(ArraysStrings.isRotation("waterbottle", "erbottlewat"));
    }

    @Test
    public void testIsRotation() {
        Assert.assertTrue(ArraysStrings.isRotation("watererbottle", "erbottlewater"));
    }

    @Test
    public void testIsRotationNegative() {
        Assert.assertFalse(ArraysStrings.isRotation("watererbottleK", "erbottlewater"));
    }

    @Test
    public void testIsRotationNegative2() {
        Assert.assertFalse(ArraysStrings.isRotation("watererbottle", "erbottlewawater"));
    }

    @Test
    public void testIsRotationPositive() {
        Assert.assertTrue(ArraysStrings.isRotation("watererbottleK", "Kwatererbottle"));
    }

    @Test
    public void testIsRotationPositive2() {
        Assert.assertTrue(ArraysStrings.isRotation("watererbottle", "atererbottlew"));
    }
}
