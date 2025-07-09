package com.javadevmz.leetcode;

/**
 * 72. Edit Distance
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * You have the following three operations permitted on a word:
 *     Insert a character
 *     Delete a character
 *     Replace a character
 */
class EditDistance {

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1]; // dynamic programming table
        // handle boundaries
        for (int i = 0; i <= n; i++)
            dp[i][0] = i; // add all the characters to the empty string
        for (int j = 0; j <= m; j++)
            dp[0][j] = j; // delete all the characters to get an emptyy string

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; //no changes
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1], // replace the character
                            Math.min(
                                    dp[i - 1][j], //delete the character
                                    dp[i][j - 1]  //insert a character
                            )
                    );
                }
            }
        }

        return dp[n][m];
    }
}