package com.javadevmz.leetcode.medium;

/**
 * 1318. Minimum Flips to Make a OR b Equal to c

 * Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
 * Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.

 * 11100011
 *    ||
 * 00101011
 *    =
 * 11001000
 */
public class MinimumFlips {

    public int minFlips(int a, int b, int c) {
        if((a | b) == c) return 0;

        int aOrB = (a | b)^c; // to flip in either number
        int aAndB = (a & b | c)^c; // to flip in both

        return numberOfOnes(aOrB) + numberOfOnes(aAndB);
    }

    //counts ones in the binary number recursively by checking the LSB and toggling right
    public int numberOfOnes(int num) {
        if(num==0) return 0;
        int count = 0;
        if((num & 1) == 1) count++;
        return count + numberOfOnes(num>>1);
    }
}
