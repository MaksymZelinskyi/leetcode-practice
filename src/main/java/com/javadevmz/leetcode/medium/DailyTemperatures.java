package com.javadevmz.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/** 739. Daily Temperatures

 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait
 * after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); //monotonous stack

        for (int i = 0; i < n; i++) {
            //mark this element as nearest to all the previous elements that are lower
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                res[prev] = i - prev;
            }
            stack.push(i); //add this element
        }

        return res;
    }
}
