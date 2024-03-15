package com.leetcode.practice.solutions;

public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length <= 1) {
            return 0;
        }
        int[] dp = new int[cost.length + 2];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 0;
        for (int i = 3; i < dp.length; i ++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 3], dp[i - 1] + cost[i - 2]);
        }
        return dp[dp.length - 1];
    }
}
