package com.javadevmz.leetcode.easy;

/**
 * 2351. First Letter to Appear Twice

 * Given a string s consisting of lowercase English letters, return the first letter to appear twice.

 * Note:

 * A letter a appears twice before another letter b if the second occurrence of a is before the second occurrence of b.
 * s will contain at least one letter that appears twice.
 */
public class FirstLetterTwice {

    public char repeatedCharacter(String s) {
        boolean[] appears = new boolean[26]; // mark letters that have appeared once
        for(char c : s.toCharArray()) {
            if(appears[c-'a']) // if is already present
                return c; // return
            appears[c-'a'] = true;
        }
        return '!';
    }
}
