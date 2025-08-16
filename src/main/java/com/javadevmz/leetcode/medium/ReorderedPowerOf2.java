package com.javadevmz.leetcode.medium;

import java.util.Arrays;
import java.util.List;

/**
 * 869. Reordered Power of 2

 * You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.

 * Return true if and only if we can do this so that the resulting number is a power of two.
 */
public class ReorderedPowerOf2 {

    //all the powers of two that enter into the int-range sorted in the lexicographical order
    private final List<String> POWERS = List.of("011237","0122579","012356789","0124","0134449", "0145678","01466788","0248","0368888","0469","1","112234778","11266777","122446","125","128","1289","13468","16","2","224588","23","23334455","234455668","23678","256","35566","4","46","8");

    public boolean reorderedPowerOf2(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        Arrays.sort(chars); //sort lexicographically
        return POWERS.contains(new String(chars));
    }
}
