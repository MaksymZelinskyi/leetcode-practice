package com.javadevmz.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1268. Search Suggestions System

 * You are given an array of strings products and a string searchWord.

 * Design a system that suggests at most three product names from products after each character of searchWord
 * is typed. Suggested products should have common prefix with searchWord. If there are more than three products
 * with a common prefix return the three lexicographically minimums products.

 * Return a list of lists of the suggested products after each character of searchWord is typed.
 */
class SearchSuggestionSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> list = new ArrayList<>();

        Arrays.sort(products); //sort to insure lexicographical order
        Trie trie = new Trie();
        for(String product : products) {
            trie.insert(product); //insert every product
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<searchWord.length(); i++) {
            list.add(trie.search(searchWord, i));
        }
        return list;
    }

    private class Trie {
        TrieNode root = new TrieNode();

        public void insert(String product) {
            char[] chars = product.toCharArray();
            TrieNode curr = root;
            for(int i = 0; i<chars.length; i++) {
                if(curr.children[chars[i]-'a']==null) {
                    curr.children[chars[i]-'a'] = new TrieNode();
                }
                curr = curr.children[chars[i]-'a'];
                if(curr.suggestions.size()<3) {
                    curr.suggestions.add(product); //add the word being inserted as a suggestion
                }
            }
            curr.isEnd = true;
        }

        /**
         * Searches for three(or less) suggestions for the part of word specified
         * @param word the searchWord
         * @param i the last index of the current part of the word(better than creating a new string on each call)
         * @return suggestions list
         */
        public List<String> search(String word, int i) {
            char[] chars = word.toCharArray();
            TrieNode curr = root;
            for(int j = 0; j<=i; j++) {
                if(curr==null) break;
                curr = curr.children[chars[j]-'a'];

            }
            return curr==null ? new ArrayList<>() : curr.suggestions;
        }
    }

    private class TrieNode {
        TrieNode[] children = new TrieNode[26]; //26 indices: one for each letter
        boolean isEnd; //unused here but necessary for a trie
        List<String> suggestions = new ArrayList<>();
    }
}
