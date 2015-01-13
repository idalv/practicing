package com.backtracking.eightqueens;

import com.backtracking.eightqueens.EightQueensProblem;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/13/15
 * Time: 12:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class EightQueensProblemTest {
    @Test
    public void run() {
        EightQueensProblem problem = new EightQueensProblem();
        problem.placeAQueen((byte) 0);
        System.out.println("Finally queens are positioned at: " + problem.getResult());
    }
}
