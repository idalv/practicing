package com.backtracking.eightqueens;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/13/15
 * Time: 11:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class EightQueensProblem {
    public static final int BOARD_SIZE = 8;
    private boolean[][] board = {{true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true}};
    private List<Queen> result = new LinkedList<Queen>();
    boolean success = false;

    public void placeAQueen(byte row) {
        for (byte column = 0; column < BOARD_SIZE; column++) {
            if (columnIsAvailable(column, row)) {
                placeInColumn(column, row);
                if (row + 1 < BOARD_SIZE) {
                    placeAQueen((byte)(row + 1));
                } else {
                    success = true;
                    return;
                }
            }
        }
        if (!success) {
            System.out.println("BACKTRACKING TRIGGERED!");
            removeFromRow((byte) (row - 1));
        }
    }

    private void placeInColumn(byte column, byte row) {
        System.out.println("Adding a queen at position [row=" + row + ", column=" + column + "].");
        // Add the queen to the result list
        result.add(new Queen(row, column));

        // Mark the board as occupied
        markBoard(column, row, false);
    }

    private void removeFromRow(byte row) {
        // Remove the queen from the result list
        Queen queen = result.remove(row);

        System.out.println("Removing a queen at position [row=" + row + ", column=" + queen.column + "].");

        clearBoard();

        for (Queen q : result) {
            // Mark the board as occupied
            markBoard(q.column, q.row, false);
        }
    }

    private void clearBoard() {
        for (byte row = 0; row < BOARD_SIZE; row++) {
            for (byte column = 0; column < BOARD_SIZE; column++) {
                board[row][column] = true;
            }
        }
    }

    private void markBoard(byte column, byte row, boolean available) {
        board[row][column] = available;

        for (byte c = 1; c < BOARD_SIZE; c++) {
            if ((row - c) >= 0 && (column - c) >= 0) {
                board[row-c][column-c] = available;
            }
            if ((row - c) >= 0) {
                board[row-c][column] = available;
            }
            if ((row - c) >= 0 && (column + c) < BOARD_SIZE) {
                board[row-c][column+c] = available;
            }
            if ((column + c) < BOARD_SIZE) {
                board[row][column+c] = available;
            }
            if ((row + c) < BOARD_SIZE && (column + c) < BOARD_SIZE) {
                board[row+c][column+c] = available;
            }
            if ((row + c) < BOARD_SIZE) {
                board[row+c][column] = available;
            }
            if ((row + c) < BOARD_SIZE && (column - c) >= 0) {
                board[row+c][column-c] = available;
            }
            if ((column - c) >= 0) {
                board[row][column-c] = available;
            }
        }
    }

    private boolean columnIsAvailable(byte column, byte row) {
        return board[row][column];
    }

    public List<Queen> getResult() {
        return result;
    }
}
