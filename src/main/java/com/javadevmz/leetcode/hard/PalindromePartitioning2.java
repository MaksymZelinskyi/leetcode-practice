package com.javadevmz.leetcode.hard;

/**
 * 132. Palindrome Partitioning II

 * Given a string s, partition s such that every substring of the partition is a palindrome.

 * Return the minimum cuts needed for a palindrome partitioning of s.
 */
public class PalindromePartitioning2 {

    public int minCut(String s) {
        int n = s.length();

        //dp-table: match every character with every character
        boolean[][] dp = new boolean[n][n];

        int[] minCuts = new int[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                //if two characters are equal and the substring between is a palindrome
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1]))
                    dp[j][i] = true; //mark as palindrome
            }
        }

        //track dynamically the solution for every prefix
        for(int i = 0; i < n; i++) {
            //if whole prefix is a palindrome, write 0
            if(dp[0][i]) minCuts[i] = 0;
            else {
                int min = i;
                for(int j = 0; j<i; j++) {
                    //if is followed by a palindrome
                    if(dp[j+1][i])
                        //take current value or add one cut to preliminary number of cuts
                        min = Math.min(min, minCuts[j] + 1);
                }
                minCuts[i] = min;
            }
        }
        return minCuts[n-1];
    }
}
