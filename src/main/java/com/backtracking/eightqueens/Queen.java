package com.backtracking.eightqueens;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/13/15
 * Time: 11:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class Queen {
    public byte row;
    public byte column;

    public Queen(byte row, byte column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "[row = " + row + ", column = " + column + "]";
    }
}
