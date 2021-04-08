package com.leetcode.practice.solutions;

public class Solution5 {

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        if (size < 1) {
            return "";
        }
        boolean[][] dp = new boolean[size][size];
        int resultStart = 0;
        int resultEnd = 0;
        int maxLen = 1;
        for(int i = 0; i < size; i ++) {
            if (isValidString(0, i, chars)) {
                dp[0][i] = true;
                if (i + 1 > maxLen) {
                    maxLen = i + 1;
                    resultStart = 0;
                    resultEnd = i;
                }
            }
        }
        for (int i = 1; i < size; i ++) {
            for (int j = i; j < size; j ++) {
                if (j + 1 < size) {
                    if (dp[i - 1][j + 1]) {
                        dp[i][j] = true;
                    } else {
                        if (isValidString(i, j, chars)) {
                            dp[i][j] = true;
                            if (j - i + 1 > maxLen) {
                                maxLen = j - i + 1;
                                resultStart = i;
                                resultEnd = j;
                            }
                        }
                    }
                } else {
                    if (isValidString(i, j, chars)) {
                        dp[i][j] = true;
                        if (j - i + 1 > maxLen) {
                            maxLen = j - i + 1;
                            resultStart = i;
                            resultEnd = j;
                        }
                    }
                }
            }
        }

        return s.substring(resultStart, resultEnd + 1);
    }

    boolean isValidString(int start, int end, char[] chars) {
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start ++;
            end --;
        }

        return true;
    }

}
