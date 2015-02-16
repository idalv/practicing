package com.problems.stacksqueues.minstack;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/16/15
 * Time: 9:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class MinNode {

    public Integer min;
    public Integer data;
    public MinNode nextNode;

    public MinNode(Integer data, Integer min) {
        this.data = data;
        this.min = min;
    }

    public MinNode(Integer data, Integer min, MinNode next) {
        this(data, min);
        this.nextNode = next;
    }
}
