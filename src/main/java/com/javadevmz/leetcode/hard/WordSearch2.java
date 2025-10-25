package com.javadevmz.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 212. Word Search II

 * Given an m x n board of characters and a list of strings words, return all words on the board.

 * Each word must be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 */
public class WordSearch2 {

    int[][] dirs = new int[][]{
            new int[]{-1, 0}, //bottom
            new int[]{1, 0}, //up
            new int[]{0, -1}, //left
            new int[]{0, 1} //right
    };
    char[][] board;
    int n, m;
    Node root = new Node(); //trie root
    List<String> res = new ArrayList<>(); //result

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        m = board.length;
        n = board[0].length;

        for (String word : words) insert(word); //populate trie

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtrack(i, j, root);
            }
        }
        return res;
    }

    //dfs through the table as long as characters are present in the trie
    public void backtrack(int i, int j, Node curr) {
        if (i < 0 || j < 0 || i>=m || j>=n || curr == null) return;
        char c = board[i][j];
        Node child = curr.next.get(c);

        //if visited or null, stop
        if (c == '#' || child == null) return;
        //if end of word
        if (child.word != null) {
            res.add(child.word); //add the word
            child.word = null; //erase the word to remove duplicates
        }

        board[i][j] = '#'; //mark as visited
        for (int[] dir : dirs) {
            backtrack(i+dir[0], j+dir[1], curr.next.get(c));
        }
        board[i][j] = c; //unmark as visited
    }

    //insert into the trie
    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            node.next.putIfAbsent(c, new Node());
            node = node.next.get(c);
        }
        node.word = word;
    }

    public static class Node {
        Map<Character, Node> next = new HashMap<>();
        String word; //marks end of the word
    }
}
