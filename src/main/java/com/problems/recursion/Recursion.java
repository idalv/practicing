package com.problems.recursion;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 3/6/15
 * Time: 6:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Recursion {
    public static int findMagic(int[] array) {
        return findMagic(array, 0, array.length - 1);
    }

    private static int findMagic(int[] array, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middle = (start + end) / 2;
        if (array[middle] == middle) {
            return middle;
        } else if (array[middle] > middle) {
            return findMagic(array, start, middle - 1);
        } else {
            return findMagic(array, middle + 1, end);
        }

    }

    public static List<ArrayList<Integer>> findSubSets(List<Integer> original) {
        return findSubSets(original, original.size()-1);
    }

    private static List<ArrayList<Integer>> findSubSets(List<Integer> original, int indexNumber) {
        if (indexNumber == -1) {
            List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            result.add(new ArrayList<Integer>());
            return result;
        }

        List<ArrayList<Integer>> subsets = findSubSets(original, indexNumber-1);
        List<ArrayList<Integer>> resultSubsets = new ArrayList<ArrayList<Integer>>();
        resultSubsets.addAll(subsets);

        for (List subset : subsets) {
            ArrayList<Integer> newSubset = new ArrayList<>(subset.size() + 1);
            newSubset.addAll(subset);
            newSubset.add(original.get(indexNumber));
            resultSubsets.add(newSubset);
        }

        return resultSubsets;
    }

    public static List<String> findPermutations(String original) {
        List<char[]> permutations = findPermutations(original.toCharArray(), original.length()-1);
        List<String> stringPermutations = new ArrayList<String>();

        for (char[] permutation : permutations) {
            stringPermutations.add(new String(permutation));
        }

        return stringPermutations;
    }

    private static List<char[]> findPermutations(char[] chars, int charIndexToInclude) {
        List<char[]> result = new ArrayList<char[]>();

        if (charIndexToInclude == 0) {
            char[] charArray = new char[1];
            charArray[0] = chars[0];
            result.add(charArray);
            return result;
        }

        List<char[]> prevPermutations = findPermutations(chars, charIndexToInclude - 1);
        for (char[] prevPerm : prevPermutations) {
            result.addAll(generateNewPermutations(prevPerm, chars[charIndexToInclude]));
        }

        return result;
    }

    private static List<char[]> generateNewPermutations(char[] prevPerm, char aChar) {
        List<char[]> result = new ArrayList<char[]>();
        for (int insertAt = 0; insertAt <= prevPerm.length; insertAt++) {
            char[] newPerm = new char[prevPerm.length+1];
            int newPermIndex = 0;
            for (int prevPermIndex = 0; prevPermIndex <= prevPerm.length; prevPermIndex++) {
                if (insertAt == newPermIndex) {
                    newPerm[newPermIndex++] = aChar;
                }

                if (prevPermIndex < prevPerm.length) {
                    newPerm[newPermIndex++] = prevPerm[prevPermIndex];
                }
            }
            result.add(newPerm);
        }
        return result;
    }

    public static void fillArea(int[][] area, int startingX, int startingY, int newColor) {
        int originalColor = area[startingX][startingY];
        fillArea(area, startingX, startingY, newColor, originalColor);
    }

    private static void fillArea(int[][] area, int x, int y, int newColor, int originalColor) {
        if (x < 0 || y < 0 || x >= area[0].length || y >= area.length) {
            return;
        }

        if (area[x][y] == newColor || area[x][y] != originalColor) {
            return;
        }

        area[x][y] = newColor;

        // Go UP
        fillArea(area, x, y-1, newColor, originalColor);
        // Go UP and RIGHT
        fillArea(area, x+1, y-1, newColor, originalColor);
        // Go RIGHT
        fillArea(area, x+1, y, newColor, originalColor);
        // Go RIGHT and DOWN
        fillArea(area, x+1, y+1, newColor, originalColor);
        // Go DOWN
        fillArea(area, x, y+1, newColor, originalColor);
        // Go DOWN and LEFT
        fillArea(area, x-1, y+1, newColor, originalColor);
        // Go LEFT
        fillArea(area, x-1, y, newColor, originalColor);
        // Go LEFT and UP
        fillArea(area, x-1, y-1, newColor, originalColor);
    }

    public static final class Box {
        int width;
        int depth;
        int height;

        public Box(int width, int depth, int height) {
            this.width = width;
            this.depth = depth;
            this.height = height;
        }

        public boolean isBigger(Box another) {
            if (another == null) {
                return true;
            }

            return this.height > another.height &&
                    this.depth > another.depth &&
                    this.width > another.width;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Box box = (Box) o;

            if (depth != box.depth) return false;
            if (height != box.height) return false;
            if (width != box.width) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = width;
            result = 31 * result + depth;
            result = 31 * result + height;
            return result;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "width=" + width +
                    ", depth=" + depth +
                    ", height=" + height +
                    '}';
        }
    }

    private static Deque<Box> currentTallest;
    private static int currentHeight;
    private static Deque<Box> maxTallest;
    private static int maxHeight;

    public static Deque<Box> buildTallest(List<Box> boxes) {
        currentTallest = new LinkedList<Box>();
        currentHeight = 0;
        maxTallest = new LinkedList<Box>();
        maxHeight = 0;

        buildTallest(boxes, 0);

        return maxTallest;
    }

    private static void buildTallest(List<Box> boxes, int index) {
        for (int i = index; i < boxes.size(); i++) {
            Box box = boxes.get(i);
            if (currentTallest.isEmpty() || (currentTallest.peekLast().isBigger(box))) {
                currentTallest.addLast(box);
                currentHeight += box.height;
                buildTallest(boxes, i + 1);
            }
        }

        if (currentHeight > maxHeight) {
            maxHeight = currentHeight;
            maxTallest = new LinkedList<Box>();
            maxTallest.addAll(currentTallest);
        }

        // Remove the last element from the stack to step back
        if (!currentTallest.isEmpty()) {
            Box lastBox = currentTallest.removeLast();
            currentHeight -= lastBox.height;
        }
    }
}