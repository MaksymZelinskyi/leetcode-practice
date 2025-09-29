package com.javadevmz.leetcode.hard;

/**
 * 312. Burst Balloons

 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

 * If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

 * Return the maximum coins you can collect by bursting the balloons wisely.
 */
public class BurstBalloons {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;

        //copy with imaginary corner balloons
        for(int i = 0; i<n; i++) {
            arr[i+1] = nums[i];
        }

        int[][] dp = new int[n+2][n+2];
        //rows - start; columns - end
        for(int len = 2; len<n+2; len++) {
            for(int left = 0; left + len < n+2; left++) {
                int right = left + len;

                for(int k = left+1; k<right; k++) {
                    int coins = arr[left] * arr[k] * arr[right] + dp[left][k] + dp[k][right]; //value if burst last
                    dp[left][right] = Math.max(dp[left][right], coins); // max value between left and right
                }
            }
        }

        return dp[0][n+1];
    }
}
