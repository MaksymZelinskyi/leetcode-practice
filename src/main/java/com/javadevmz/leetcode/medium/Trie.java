package com.javadevmz.leetcode.medium;

public class Trie {

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node current = root;
        for(int i = 0; i<word.length(); i++) {
            char c = word.charAt(i);
            Node child = current.children[c-'a'];
            if(child==null) {
                child = new Node(c);
                current.children[c-'a'] = child;
            }
            current = child;
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        Node node = findLastNodeOf(word);
        return node != null && node.endOfWord;
    }

    public boolean startsWith(String prefix) {
        Node node = findLastNodeOf(prefix);
        return node != null;
    }

    private Node findLastNodeOf(String word) {
        Node current = root;
        for(int i = 0; i<word.length(); i++) {
            char c = word.charAt(i);
            Node child = current.children[c-'a'];
            if(child==null) return null;
            current = child;
        }
        return current;
    }
    private class Node {
        Node[] children = new Node[26];
        char value;
        boolean endOfWord;

        Node(char value) {
            this.value = value;
        }

        Node() {}
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

