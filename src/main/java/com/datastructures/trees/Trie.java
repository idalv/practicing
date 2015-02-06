package com.datastructures.trees;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/6/15
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class Trie {
    private TrieNode root = new TrieNode();
    private List<String> words = new ArrayList<String>();
    private Deque<Character> charSequence = new LinkedList<Character>();

    public void addWord(String word) {
        if (word == null) {
            return;
        }

        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                TrieNode node = new TrieNode();
                current.children.put(c, node);
            }
            current = current.children.get(c);
        }
    }

    public List<String> getWords() {
        words.clear();
        TrieNode current = root;
        dfs(current);

        return words;
    }

    public List<String> getWords(String prefix) {
        if (prefix == null || prefix.trim().length() == 0) {
            return getWords();
        }

        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                return Collections.EMPTY_LIST;
            }
        }

        words.clear();
        dfs(current);
        return words;
    }

    private void dfs(TrieNode current) {
        if (current.children.isEmpty()) {
            storeWord();
        }

        for (Map.Entry<Character, TrieNode> entry : current.children.entrySet()) {
            charSequence.addLast(entry.getKey());
            dfs(entry.getValue());
            charSequence.removeLast();
        }
    }

    private void storeWord() {
        // This is a leaf. Add the char sequence that is build to the list of words
        StringBuilder word = new StringBuilder(charSequence.size());
        Iterator<Character> charIter = charSequence.iterator();
        while (charIter.hasNext()) {
            word.append(charIter.next());
        }
        words.add(word.toString());
    }
}
