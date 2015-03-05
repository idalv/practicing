package com.problems.ood.filesystem;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 3/5/15
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Directory {
    private Directory parent;
    private String name;
    private Map<String, Directory> directories = new HashMap<String, Directory>();
    private Map<String, File> files = new HashMap<String, File>();

    protected Directory(String name) {
        this.name = name;
    }

    public Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return this.name;
    }

    public Directory getDirectory(String name) {
        return directories.get(name);
    }

    public Collection<Directory> getAllDirectories() {
        return directories.values();
    }

    public File getFile(String name) {
        return files.get(name);
    }

    public Collection<File> getAllFiles() {
        return files.values();
    }

    @Override
    public String toString() {
        return "Directory{" +
                "name='" + name + '\'' +
                '}';
    }

    public void addDirectory(Directory directory) {
        this.directories.put(directory.getName(), directory);
    }

    public void removeDirectory(String name) {
        this.directories.remove(name);
    }

    public Directory getParent() {
        return this.parent;
    }
}
