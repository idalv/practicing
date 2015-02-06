package com.datastructures.trees;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/6/15
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class TrieTest {
    @Test
    public void testWordAddGet() {
        Trie trie = new Trie();

        trie.addWord("alabama");
        trie.addWord("alaska");
        trie.addWord("amsterdam");
        trie.addWord("sofia");

        List<String> words = trie.getWords();
        Assert.assertArrayEquals(new String[] {"alabama", "alaska", "amsterdam", "sofia"}, words.toArray(new String[]{}));
    }

    @Test
    public void testAutocomplete() {
        Trie trie = new Trie();

        trie.addWord("alabama");
        trie.addWord("alaska");
        trie.addWord("amsterdam");
        trie.addWord("sofia");

        Assert.assertArrayEquals(new String[] {"alabama", "alaska", "amsterdam", "sofia"}, trie.getWords("").toArray(new String[]{}));
        Assert.assertArrayEquals(new String[] {"fia"}, trie.getWords("so").toArray(new String[]{}));
        Assert.assertArrayEquals(new String[] {"labama", "laska", "msterdam"}, trie.getWords("a").toArray(new String[]{}));
        Assert.assertArrayEquals(new String[] {"abama", "aska"}, trie.getWords("al").toArray(new String[]{}));
    }
}
