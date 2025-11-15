package com.javadevmz.leetcode.medium;

/**
 * 45. Jump Game II

 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.

 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j) where:

 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.
 */
public class JumpGame2 {

    public int jump(int[] nums) {
        return count(nums, 0, 0);
    }

    public int count(int[] nums, int st, int end) {
        if (end >= nums.length - 1) { //base case
            return 0;
        }

        int newEnd = end;

        for (int i = st; i < end; i++) {
            newEnd = Math.max(newEnd, nums[i] + i); //furthest at this step
        }

        return 1 + count(nums, end + 1, newEnd); //recurse
    }
}
