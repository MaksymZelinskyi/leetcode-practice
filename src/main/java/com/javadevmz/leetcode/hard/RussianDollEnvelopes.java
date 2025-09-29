package com.javadevmz.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 354. Russian Doll Envelopes

 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

 * One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

 * Note: You cannot rotate an envelope.
 */
public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;

        Arrays.sort(envelopes, (x, y) -> {
            if(x[0] == y[0]) //sort by width
                return y[1] - x[1];
            return x[0] - y[0]; //sort by height in reverse order
        });

        int[] heights = new int[n]; //collect heights array
        for(int i = 0; i<n; i++) {
            heights[i] = envelopes[i][1];
        }

        return lengthOfLIS(heights); //greatest increasing sequence
    }

    private int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();

        for(int num : nums) {
            int idx = Collections.binarySearch(lis, num); //find next number in lis
            if(idx < 0) //if absent
                idx = -(idx + 1); //where it might be

            if(idx == lis.size()) { //if greater than all
                lis.add(num); // add
            } else {
                lis.set(idx, num); //replace existing
            }
        }
        return lis.size();
    }

}
