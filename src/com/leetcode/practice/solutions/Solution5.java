package com.leetcode.practice.solutions;

public class Solution5 {

    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        int start = 0;
        int length = 0;
        boolean[][] dp = new boolean[size][size];
        for (int len = 1; len <= size; len ++) {
            for (int i = 0; i <= size - len; i ++) {
                if (len == 1) {
                    dp[i][i] = true;
                    if (length < 1) {
                        start = i;
                        length = 1;
                    }
                    continue;
                }
                if (len == 2) {
                    if (chars[i] == chars[i + 1]) {
                        dp[i][i + 1] = true;
                        if (length < 2) {
                            start = i;
                            length = 2;
                        }
                    }
                    continue;
                }

                if (dp[i + 1][i + len - 2]) {
                    if (chars[i] == chars[i + len - 1]) {
                        dp[i][i + len - 1] = true;
                        if (len > length) {
                            start = i;
                            length = len;
                        }
                    }
                }

            }
        }

        return s.substring(start, start + length);
    }

}
