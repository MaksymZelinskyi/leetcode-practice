package com.javadevmz.leetcode.medium;

/**
 * 198. House Robber
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is
 * that adjacent houses have security systems connected and it will automatically contact the police if two adjacent
 * houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {

    public int rob(int[] nums) {
        //edge cases
        if(nums.length==1)return nums[0];
        if(nums.length==2)return Math.max(nums[0], nums[1]);

        int sum = 0;
        //dp-array
        int[] takenSums = new int[nums.length];
        takenSums[0]=nums[0];
        takenSums[1]=Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++){
            // pre previous plus current or previous to avoid adjacency
            takenSums[i] = Math.max(takenSums[i-2]+nums[i], takenSums[i-1]);
        }
        return takenSums[takenSums.length-1];
    }
}