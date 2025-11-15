package com.javadevmz.leetcode.medium;

/**
 * 134. Gas Station

 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique.
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0, totalCost = 0;
        //compute total cost and total gas to find out if there's enough gas in total
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalCost > totalGas)
            return -1; //uncompletable(the only case)

        int start = 0;
        int balance = 0;
        for (int i = 0; i < n; i++) {
            balance += gas[i] - cost[i];
            if (balance < 0) {
                balance = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
