package com.leetcode.practice.solutions;

public class Solution96 {

    public static int numTrees(int n) {
        int[] dp = new int[Math.max(n + 1, 3)];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i ++) {
            for (int left = 0; left < i; left ++) {
                dp[i] += dp[left] * dp[i - left - 1];
            }
        }
        return dp[n];
    }

}
