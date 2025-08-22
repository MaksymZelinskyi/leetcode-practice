package com.javadevmz.leetcode.medium;

/**
 *1071. Greatest Common Divisor of Strings

 * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 */
public class GCDOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        String smaller = str1.length()<str2.length()?str1:str2; // the shorter string
        for(int i=1; i<=smaller.length(); i++){
            if(smaller.length()%i==0){ //length divides by substring length
                String substring = smaller.substring(0, smaller.length()/i);
                if(divides(substring, str1) && divides(substring, str2))
                    return substring;
            }
        }
        return "";
    }

    //if all the substrings with the length of divisor are equal, return true
    private boolean divides(String divisor, String str){
        if(str.length()%divisor.length()!=0)return false;
        for(int i=0; i<str.length()/divisor.length(); i++){
            if(!divisor.equals(str.substring(divisor.length()*i, divisor.length()*(i+1)))){
                return false;
            }
        }
        return true;
    }
}
