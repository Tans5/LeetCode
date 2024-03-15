package com.leetcode.practice.solutions;


public class Solution740 {

    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int n: nums) {
            if (n > max) {
                max = n;
            }
        }
        int[] values = new int[max + 1];
        for (int n: nums) {
            values[n] += n;
        }
        int[][] dp = new int[values.length][2];
        dp[0][0] = 0;
        dp[0][1] = values[0];
        for (int i = 1; i < values.length; i ++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + values[i];
        }
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1] [1]);
    }
}
