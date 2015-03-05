package com.problems.ood.filesystem;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 3/5/15
 * Time: 6:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileSystem {
    private Directory currentDirectory;

    public FileSystem() {
        this.currentDirectory = RootDirectory.getInstance();
    }

    public void print() {
        System.out.print("" + currentDirectory.getName() + "$:");
    }

    public void cd(String name) {
        currentDirectory = currentDirectory.getDirectory(name);
    }

    public void ls() {
        System.out.println(currentDirectory.getAllDirectories());
    }

    public void mkDir(String name) {
        Directory newDirectory = new Directory(name, currentDirectory);
        currentDirectory.addDirectory(newDirectory);
    }

    public void rmDir(String name) {
        currentDirectory.removeDirectory(name);
    }

    public void cdUP() {
        if (currentDirectory == RootDirectory.getInstance()) {
            return;
        }

        currentDirectory = currentDirectory.getParent();
    }
}
