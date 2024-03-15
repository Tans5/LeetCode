package com.leetcode.practice.solutions;

public class Solution70_2 {

    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int s = 2; s < n; s ++) {
            dp[s] = dp[s - 1] + dp[s - 2];
        }
        return dp[n - 1];
    }
}
