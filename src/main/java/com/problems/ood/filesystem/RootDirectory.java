package com.problems.ood.filesystem;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 3/5/15
 * Time: 6:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class RootDirectory extends Directory {
    private static RootDirectory instance = null;

    private RootDirectory() {
        super("/");
    }

    public static RootDirectory getInstance() {
        if (instance == null) {
            instance = new RootDirectory();
        }

        return instance;
    }
}
