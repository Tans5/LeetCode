package com.leetcode.practice.solutions;

public class Solution516 {

    public static int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        int[][] dp = new int[size][size];
        for (int start = size - 1; start >= 0; start --) {
            dp[start][start] = 1;
            for (int end = start + 1; end < size; end ++) {
                if (chars[start] == chars[end]) {
                    if (end - start <= 1) {
                        dp[start][end] = 2;
                    } else {
                        dp[start][end] = dp[start + 1][end - 1] + 2;
                    }
                } else {
                    dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                }
            }
        }
        return dp[0][size - 1];
    }
}
