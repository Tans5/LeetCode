package com.leetcode.practice.solutions;

public class Solution300 {

    public static int lengthOfLIS(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < size; i ++) {
            boolean isMin = true;
            int focus = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < focus) {
                    isMin = false;
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (isMin) {
                dp[i] = 1;
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }
}
