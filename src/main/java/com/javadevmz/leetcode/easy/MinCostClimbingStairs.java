package com.javadevmz.leetcode.easy;

/**
 * 746. Min Cost Climbing Stairs

 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

 * You can either start from the step with index 0, or the step with index 1.

 * Return the minimum cost to reach the top of the floor.
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        //edge cases
        if(cost.length==2)return Math.min(cost[0], cost[1]);
        if(cost.length==3)return Math.min(cost[1], cost[0]+cost[2]);

        int[] dp = new int[cost.length]; //dynamic programming
        dp[dp.length-1] = cost[cost.length-1];
        dp[dp.length-2] = cost[cost.length-2];
        //iterate from the end
        for(int i=cost.length-3; i>=0; i--){
            dp[i] = cost[i] + Math.min(
                    dp[i+1], //one step
                    dp[i+2]  //two steps
            );
        }
        return Math.min(
                dp[0], //start at first
                dp[1]  //start at second
        );
    }
}
