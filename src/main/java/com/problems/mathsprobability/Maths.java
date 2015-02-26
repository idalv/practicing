package com.problems.mathsprobability;

import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/26/15
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Maths {
    public static int multiply(int x, int y) {
        if (x == 0 || y == 0) {
            return 0;
        }

        if (x < 0 && y < 0) {
            return multiply(Math.abs(x), Math.abs(y));
        }
        if (y < 0) {
            return multiply(y, x);
        }

        int result = 0;
        while (y > 0) {
            result += x;
            y--;
        }

        return result;
    }

    public static int subtract(int x, int y) {
        if (y > x) {
            return multiply(-1, subtract(y, x));
        }

        int result = 0;
        while (y + result != x) {
            result += 1;
        }

        return result;
    }

    public static int divide(int x, int y) throws InvalidArgumentException {
        if (x == 0) {
            return 0;
        }

        if (y == 0) {
            throw new InvalidArgumentException(new String[]{"Division by zero"});
        }

        if (x < 0 ^ y < 0) {
            return multiply(-1, divide(Math.abs(x), Math.abs(y)));
        }

        x = Math.abs(x);
        y = Math.abs(y);

        if (y > x) {
            return 0;
        }

        int result = 1;
        while (multiply(y, result) != x) {
            result += 1;
        }

        return result;
    }
}
