package com.datastructures.trees;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/14/15
 * Time: 12:43 PM
 * To change this template use File | Settings | File Templates.
 */
public interface NodeVisitor<T> {
    void visitNode (Node<T> node);
}
