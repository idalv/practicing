package com.datastructures.trees;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/6/15
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class TrieNode {
    public Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
}
