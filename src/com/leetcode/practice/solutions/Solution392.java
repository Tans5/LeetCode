package com.leetcode.practice.solutions;

public class Solution392 {

    public boolean isSubsequence(String s, String t) {
        char[] subChars = s.toCharArray();
        if (subChars.length == 0) {
            return true;
        }
        char[] mainChars = t.toCharArray();

        int subCharsIndex = 0;
        for (int i = 0; i < mainChars.length; i ++) {
            if (subChars[subCharsIndex] == mainChars[i]) {
                subCharsIndex ++;
                if (subCharsIndex == subChars.length) {
                    return true;
                }
            }
        }
        return false;
    }

}
