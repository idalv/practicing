package com.problems.arraysstrings;

import java.util.BitSet;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/11/15
 * Time: 11:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class ArraysStrings {
    public static boolean uniqueCharacters(String text) {
        if (text == null) {
            return true;
        }

        BitSet set = new BitSet();
        for (int i = 0; i < text.length(); i++) {
            char c = Character.toUpperCase(text.charAt(i));
            int index = (int) c - 'A';
            if (set.get(index)) {
                return false;
            }

            set.set(index);
        }

        return true;
    }

    public static String reverse(String text) {
        char[] charArray = text.toCharArray();
        for (int i = 0, j = charArray.length - 1; i != j; i++, j--) {
            char tmp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = tmp;
        }

        return new String(charArray);
    }

    public static String replaceEmpty(String text, int length) {
        if (text == null) {
             return null;
        }

        char[] textChars = text.toCharArray();
        for (int textIndex = length - 1, arrayIndex = textChars.length - 1; textIndex >= 0; textIndex--) {
            if (textChars[textIndex] == ' ') {
                textChars[arrayIndex--] = '0';
                textChars[arrayIndex--] = '2';
                textChars[arrayIndex--] = '%';
            } else {
                textChars[arrayIndex--] = textChars[textIndex];
            }
        }

        return new String(textChars);
    }

    public static boolean isRotation(String original, String rotated) {
        // Lets check watererbottle and erbottlewater

        if (original.length() != rotated.length() ||
                original.equals(rotated)) {
            return false;
        }

        char[] originalArr = original.toCharArray();
        char[] rotatedArr = rotated.toCharArray();
        // Lets find the rotation point
        StringBuilder firstPart = new StringBuilder();
        StringBuilder secondPart = new StringBuilder();
        int j = 0;
        for (int i = 0; i < originalArr.length; i++) {
            if (originalArr[i] != rotatedArr[j]) {
                // We might have entered the second part and then we might have found a difference
                // In the example we have processed 'wat' and put it in the first and the first 'er'
                // we would have put it in the second
                if (secondPart.length() > 0) {
                    // Put the second in the first
                    firstPart.append(secondPart);
                    // Return the index on the original to process again the last letter
                    i--;
                    // Reset the index on the rotated and clear the second part to start a new comparison
                    j = 0;
                    secondPart = new StringBuilder();
                } else {
                    // We are still in the first part
                    firstPart.append(originalArr[i]);
                }
            } else {
                // Second part has started
                secondPart.append(originalArr[i]);
                j++;
            }
        }

        // At this point we have split the original in two - first and second parts
        // And we have check that the rotated begins with the second part

        // Now lets see whether the rotated ends with the first part
        StringBuilder rotatedSecond = new StringBuilder();
        while (j < rotatedArr.length) {
            rotatedSecond.append(rotatedArr[j++]);
        }

        return firstPart.toString().equals(rotatedSecond.toString());
    }


    public static void main(String[] args) {
        System.out.println("test the test  ".toCharArray());
    }
}
