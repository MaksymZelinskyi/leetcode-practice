package com.javadevmz.leetcode.hard;

import java.util.*;

/**
 * 126. Word Ladder II

 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList,
 * return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
 */
class WordLadder2 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> parents = new HashMap<>(); // graph
        Map<String, Integer> dist = new HashMap<>(); //shortest distance

        q.add(beginWord);
        dist.put(beginWord, 1);
        for(int i = 0; i<n; i++) {
            set.add(wordList.get(i));
        }
        set.remove(beginWord); // remove, in case it has appeared in the wordList

        while(!q.isEmpty() && !set.isEmpty()) {
            String word = q.poll();
            int step = dist.get(word);

            set.remove(word);
            if(word.equals(endWord) ) {
                break;
            }

            for(int i = 0; i<word.length(); i++) {
                char[] chars = word.toCharArray();
                // create a word different by one letter
                for(char j = 'a'; j<='z'; j++) {
                    chars[i] = j;
                    String newString = new String(chars);
                    // if appears in wordList and not taken yet
                    if(set.contains(newString)) {
                        if (!dist.containsKey(newString)) {
                            dist.put(newString, step + 1);
                            q.add(newString); // add into the queue
                            parents.put(newString, new ArrayList<>());
                        }
                        // shortest path neighbor
                        if (dist.get(newString) == step + 1) {
                            parents.get(newString).add(word); // add parent
                        }
                    }
                }
            }
        }
        // find shortest paths
        dfs(endWord, beginWord, new ArrayList<>(), parents, list);
        return list;
    }

    public void dfs(String current, String beginWord, List<String> path, Map<String, List<String>> parents, List<List<String>> lists) {
        path.add(current);
        if(current.equals(beginWord)) {
            List<String> copy = new ArrayList<>(path);
            Collections.reverse(copy);
            lists.add(copy);
        } else if(parents.containsKey(current)){
            for(String s : parents.get(current)) {
                dfs(s, beginWord, path, parents, lists);
            }

        }
        path.remove(path.size()-1);
    }

}