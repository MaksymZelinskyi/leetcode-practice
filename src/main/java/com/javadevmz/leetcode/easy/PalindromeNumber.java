package com.javadevmz.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 9. Palindrome Number
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x<0) return false;
        List<Integer> digits = new ArrayList<>();
        int copy = x; //create a copy to collect the digits

        while(copy>0){
            digits.add(copy%10); //take the rightmost digit
            copy/=10;
        }

        //compare every digit from right to left with digits from left to right
        for(int i=digits.size()-1; i>=0; i--) {
            if(digits.get(i)!=(x%10))
                return false;
            x/=10;
        }
        return true;
    }
}
