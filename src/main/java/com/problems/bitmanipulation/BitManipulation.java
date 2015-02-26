package com.problems.bitmanipulation;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/23/15
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class BitManipulation {
    public static int combine(int n, int m, int i, int j) {
        // Clear the bits from j to i
        int maskFromITillEnd = (1 << i) - 1;
        int maskFromBeginningTillJ = ~(-1 >>> 31-j);
        int mask = maskFromBeginningTillJ | maskFromITillEnd;
        n = n & mask;

        // Shift to align m and add it to n
        return n | (m << i);
    }

    public static String printBinary(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while (num > 0) {
            num = num * 2;
            if (num >= 1) {
                binary.append(1);
                num = num - 1;
            } else {
                binary.append(0);
            }
        }

        return binary.toString();
    }

    public static int printNext(int c) {
        // count the trailing 0s
        int n = c;
        int c0 = 0;
        while ((n & 1) == 0 && n != 0) {
            c0++;
            n >>= 1;
        }

        // count the 1s before the trailing 0s
        int c1 = 0;
        while ((n & 1) == 1) {
            c1++;
            n >>= 1;
        }

        int p = c0 + c1;
        // Now if the number looks like 1111...0000 then there is no next number with same number of 1s
        if (p >= 31) {
            return -1;
        }

        // Turn the bit at position p to 1
        c = c | (1 << p);
        // Clear the bits after position p
        c = c & ~((1 << p) - 1);
        // Place correct number of 1s to the left
        c = c | ((1 << c1-1) - 1);

        return c;
    }

    public static int printPrevious(int n) {
        int c = n;

        // find the number of trailing 1s
        int c1 = 0;
        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        // find the number of 0s before the trailing 1s
        int c0 = 0;
        while ((c & 1) == 0 && c != 0) {
            c0++;
            c >>= 1;
        }

        // if the number is 000011111 there is no previous number with same number of 1s
        int p = c0 + c1;
        if (p >= 31) {
            return -1;
        }

        // turn the bit at p to 0
        n = n & ~(1 << p);
        // clear the bits after p
        n = n & ~((1 << p) - 1);
        // place correct number of 1s right after p
        n = n | (((1 << (c1+1)) - 1) << (c0-1));

        return n;
    }

    public static int countFlips(int n, int m) {
        int diff = n ^ m;

        int countDiffs = 0;
        while (diff != 0) {
            if ((diff & 1) == 1) {
                countDiffs++;
            }
            diff >>= 1;
        }

        return countDiffs;
    }

    public static int flipOddEven(int n) {
        int c1 = n;
        int c2 = n >> 1;

        int result = 0;
        int shift = 0;
        while (c1 != 0) {
            result = result | ((c2 & 1) << shift);
            result = result | ((c1 & 1) << (shift + 1));
            c1 >>= 2;
            c2 >>= 2;
            shift += 2;
        }

        return result;
    }

    public static int flipOddEvenOptimal(int n) {
//        return (n & 0xaaaaaaaa) >> 1 | (n & 0x55555555) << 1;
        return (n & 0b10101010101010101010101010101010) >> 1
                | (n & 0b01010101010101010101010101010101) << 1;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(-4));
//
//        System.out.println(-4>>1);
//        System.out.println(Integer.toBinaryString(-4>>1));
//
//        System.out.println(-4>>>1);
//        System.out.println(Integer.toBinaryString(-4>>>1));

        System.out.println(Integer.toBinaryString(72));
        printNext(72);
    }
}
