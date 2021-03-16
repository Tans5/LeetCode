package com.leetcode.practice.solutions;

public class Solution28 {

    public int strStr(String haystack, String needle) {
        int pSize = haystack.length();
        int cSize = needle.length();
        if (cSize > pSize) {
            return -1;
        }
        if (pSize == 0 || cSize == 0) {
            return 0;
        }
        for (int start = 0, end = cSize; end <= pSize; start++, end++) {
            for (int cIndex = 0; cIndex < cSize; cIndex ++) {
                if (needle.charAt(cIndex) != haystack.charAt(start + cIndex)) {
                    break;
                }
                if (cIndex == cSize - 1) {
                    return start;
                }
            }
        }
        return -1;
    }
}
