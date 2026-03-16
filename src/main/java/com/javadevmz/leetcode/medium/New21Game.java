package com.javadevmz.leetcode.medium;

/**
 * 837. New 21 Game
 * Alice plays the following game, loosely based on the card game "21".

 * Alice starts with 0 points and draws numbers while she has less than k points. During each draw, she gains an integer number of points randomly from the range [1, maxPts], where maxPts is an integer. Each draw is independent and the outcomes have equal probabilities.

 * Alice stops drawing numbers when she gets k or more points.

 * Return the probability that Alice has n or fewer points.

 * Answers within 10-5 of the actual answer are considered accepted.
 */
public class New21Game {

    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || k+maxPts+1 <= n) return 1.0;

        double[] dp = new double[maxPts]; //sliding window of maxPts last values
        dp[0] = 1.0;
        double windowSum = 1.0; //sum of the dp elements
        double res = 0.0;

        //each winning amount
        for (int i = 1; i <= n; i++) {
            double prob = windowSum / maxPts; //sum of the window out of maxPts

            //maintain the sliding window until k points
            if (i < k) {
                windowSum += prob;
            } else {
                res += prob;
            }

            windowSum -= dp[i%maxPts];
            dp[i%maxPts] = prob;
        }

        return res;
    }
}
