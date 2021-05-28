package com.leetcode.practice.solutions;

public class Solution647 {


    public static int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[chars.length][chars.length];
        int count = 0;
        int size = chars.length;
        for (int len = 1; len <= size; len ++) {
            for (int i = 0; i <= size - len; i ++) {
                if (len == 1) {
                    count ++;
                    dp[i][i] = true;
                    continue;
                }
                if (len == 2) {
                    if (chars[i] == chars[i + 1]) {
                        count ++;
                        dp[i][i + 1] = true;
                    }
                    continue;
                }
                int endIndex = i + len - 1;
                if (dp[i + 1][endIndex - 1] && chars[i] == chars[endIndex]) {
                    count ++;
                    dp[i][endIndex] = true;
                }
            }

        }
        return count;
    }
}
