package com.leetcode.practice.solutions;

public class Solution53 {

    public static int maxSubArray(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < size; i ++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = nums[i] + dp[i - 1];
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
