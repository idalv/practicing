package com.problems.treesgraphs.pathtrees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/20/15
 * Time: 4:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Path {
    public Queue<Integer> path = new LinkedList<Integer>();
    public int sum;

    public Path() {

    }

    public Path(Path original) {
        for (Integer key : original.path) {
            this.add(key);
        }
    }

    public void add(Integer key) {
        path.add(key);
        sum += key;
    }

    public void remove() {
        int key = path.poll();
        sum -= key;
    }

    public void print() {
        for (Integer key : this.path) {
            System.out.print(key);
        }
    }
}
