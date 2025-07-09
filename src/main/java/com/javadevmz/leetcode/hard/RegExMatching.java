package com.javadevmz.leetcode.hard;

/**
 * 10. Regular Expression Matching
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 *     '.' Matches any single character.
 *     '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 */
public class RegExMatching {

    public boolean isMatch(String s, String p) {
        if(s.isEmpty())
            //a simple edge-case handling, which works. Ideally, we need to verify that p contains only characters followed by *, if p.length()>2
            return p.isEmpty() || (p.charAt(1)=='*');
        //first character matches
        boolean firstMatch = (p.charAt(0) == s.charAt(0)) || (p.charAt(0) == '.');

        if(p.charAt(1)=='*') {
            //take the remainder of s to try to extend the '*' match
            return firstMatch && isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
        }else{
            //verify that the first character matches and the remainder matches the rest of the pattern
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    /*
    Cheat solution
     */
    public boolean cheatIsMatch(String s, String p) {
        return s.matches(p);
    }
}
