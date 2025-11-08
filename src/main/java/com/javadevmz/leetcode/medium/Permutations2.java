package com.javadevmz.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    47. Permutations II
    Given a collection of numbers, nums, that might contain duplicates,
    return all possible unique permutations in any order.
 */
public class Permutations2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] marked = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, list, res, marked);

        return res;
    }

    public void backtrack(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] marked) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list)); // add list once all the elements are in
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (marked[i]) continue;

            if (i>0 && nums[i-1] == nums[i] && !marked[i-1]) // the result for two equal elements at the same level will be the same
                continue; // skip if duplicate

            //backtrack
            list.add(nums[i]);
            marked[i] = true;

            backtrack(nums, list, res, marked);

            list.remove(list.size()-1);
            marked[i] = false;
        }
    }
}
