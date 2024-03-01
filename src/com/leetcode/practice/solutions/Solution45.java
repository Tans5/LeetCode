package com.leetcode.practice.solutions;

public class Solution45 {

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i ++) {
            int minStep = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                int max = nums[j];
                int min = i - j;
                if (max >= min) {
                    int currentStep = dp[j] + 1;
                    if (currentStep < minStep) {
                        minStep = currentStep;
                        break;
                    }
                }
            }
            dp[i] = minStep;
        }
        return dp[dp.length - 1];
    }
}
