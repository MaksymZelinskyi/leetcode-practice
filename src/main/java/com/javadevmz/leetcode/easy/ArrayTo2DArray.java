package com.javadevmz.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 *

 * You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:

 * The 2D array should contain only the elements of the array nums.
 * Each row in the 2D array contains distinct integers.
 * The number of rows in the 2D array should be minimal.
 * Return the resulting array. If there are multiple answers, return any of them.

 * Note that the 2D array can have a different number of elements on each row.
 */
public class ArrayTo2DArray {

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int[] freq = new int[nums.length+1]; //count the frequencies of all the values(affordable, because 1 <= nums[i] <= nums.length)

        for(int i = 0; i<nums.length; i++) {
            while(freq[nums[i]]>=lists.size()) //create a new list only when freq[nums[i]] exceeds the number of lists
                lists.add(new ArrayList<>());

            lists.get(freq[nums[i]]).add(nums[i]); //add to the first list where it isn't present
            freq[nums[i]]++;
        }

        return lists;
    }
}
