package com.leetcode.practice.solutions;

public class Solution1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        for (int i = 1; i <= chars1.length; i ++) {
            char char1 = chars1[i - 1];
            for (int j = 1; j <= chars2.length; j ++) {
                char char2 = chars2[j - 1];
                if (char1 == char2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[chars1.length][chars2.length];
    }

}
