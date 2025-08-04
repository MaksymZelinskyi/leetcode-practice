package com.javadevmz.leetcode.easy;

/**
 * 136. Single Number
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class SingleNumber {

    /*
    Applies XOR to all the numbers, because (x^=x == 0), (while x^=y == y),
    and hence the duplicates will erase each other, keeping only the single number
     */
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i = 1; i<nums.length; i++) {
            result^=nums[i];
        }
        return result;
    }
}
