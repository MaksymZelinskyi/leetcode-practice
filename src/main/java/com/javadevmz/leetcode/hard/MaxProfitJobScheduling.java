package com.javadevmz.leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * 1235. Maximum Profit in Job Scheduling

 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

 * You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 */
public class MaxProfitJobScheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        int[][] jobs = new int[n][3];
        //dynamic programming sorted map: key - endTime; value - max profit by that time
        TreeMap<Integer, Integer> dp = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1])); //sort by endtime

        dp.put(0, 0); //put the lowest entry possible to avoid NullPointerException
        for (int i = 0; i < n; i++) {
            int curr = dp.lowerEntry(jobs[i][0]).getValue() //greatest amount earned before this job starts
                    + profit[i]; //+current profit
            if(curr > dp.lastEntry().getValue()) {
                dp.put(jobs[i][1], curr); //add if greater than max recorded
            }
        }

        return dp.lastEntry().getValue(); //return max value
    }
}
