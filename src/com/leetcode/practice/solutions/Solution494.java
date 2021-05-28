package com.leetcode.practice.solutions;

public class Solution494 {

    public static int findTargetSumWays(int[] nums, int target) {
        int size = nums.length;
        int[][] dp = new int[size][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < size; i ++) {
            for (int sum = -1000; sum <= 1000; sum ++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + 1000 + nums[i]] += dp[i - 1][sum + 1000];
                    dp[i][sum + 1000 - nums[i]] += dp[i - 1][sum + 1000];
                }
            }
        }
        return dp[size - 1][target + 1000];
    }
}
