package com.javadevmz.leetcode.medium;

import java.util.Arrays;

/**
 * 435. Non-overlapping Intervals

 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals
 * you need to remove to make the rest of the intervals non-overlapping.

 * Note that intervals which only touch at a point are non-overlapping.
 * For example, [1, 2] and [2, 3] are non-overlapping.
 */
public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[1]!=y[1] ? x[1]-y[1] : x[0]-y[0]); //sort by the second value
        int count = 0;
        int[] kept = intervals[0]; //the leftmost interval should be kept
        for(int i = 1; i<intervals.length; i++) {
            if(intervals[i][0]<kept[1]) {
                count++; //remove if overlaps with the previous interval
            }else {
                kept = intervals[i]; // reassign the interval to be kept
            }
        }
        return count;
    }
}
