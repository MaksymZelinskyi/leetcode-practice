package com.javadevmz.leetcode.easy;

/**
 * 70. Climbing Stairs
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
class ClimbingStairs {

    /*
    Add the results for n-1 and n-2 because only from these points n can be reached in one move.
    The sequence of results corresponds to the Fibonacci sequence.
    Only the loop-based solution allows to touch every element only once
    */
    public int climbStairs(int n) {
        //edge cases
        if(n==1)return 1;
        if(n==2)return 2;

        int a=1; //n-2
        int b=2; //n-1
        int res = 3; //n

        for(int i = 4; i<=n; i++){
            a=b;
            b=res;
            res=a+b;
        }
        return res;
    }

}