package com.problems.ood.callcenter;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 3/4/15
 * Time: 11:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class Call {
    public enum Type {
        HARD, MEDIUM, EASY;
    }

    public Call(Type type) {
        this.type = type;
    }

    Type type;
}
