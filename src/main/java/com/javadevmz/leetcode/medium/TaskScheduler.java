package com.javadevmz.leetcode.medium;

/*
621. Task Scheduler

You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n.
Each CPU interval can be idle or allow the completion of one task.
Tasks can be completed in any order, but there's a constraint:
there has to be a gap of at least n intervals between two tasks with the same label.

Return the minimum number of CPU intervals required to complete all tasks
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int maxFreq = 0;
        int maxFreqCount = 0;
        int[] freq = new int[26];
        //compute label frequencies
        for (char c : tasks) {
            freq[c - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] >= maxFreq) {
                if (freq[i] > maxFreq) {
                    maxFreq = freq[i]; //find greatest frequency
                    maxFreqCount = 0;
                }
                maxFreqCount++; //count if many labels have the same as max frequency
            }
        }

        int res = (maxFreq - 1) * (n+1) + maxFreqCount;
        return Math.max(res, tasks.length); //at least one interval per task
    }
}
