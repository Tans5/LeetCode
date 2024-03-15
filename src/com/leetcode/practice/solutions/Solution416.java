package com.leetcode.practice.solutions;

public class Solution416 {

    public boolean canPartition(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        int sum = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int n : nums) {
            sum += n;
            if (n > maxNum) {
                maxNum = n;
            }
        }
        if (sum % 2 != 0) {
            return false;
        }
        int targetSum = sum / 2;
        if (maxNum > targetSum) {
            return false;
        }
        // i 表示 nums 前 i 个元素，j 表示 目标值。也就是前 i 个元素中是否有子集合的和等于 j.
        boolean[][] dp = new boolean[nums.length][targetSum + 1];
        // target 为 0 就表示空集合，也就是这种情况都为 true
        for (int i = 0; i < dp.length; i ++) {
            dp[i][0] = true;
        }
        // 如果只选第 0 个元素，同时它的target 正好等于 nums[0]，这种情况肯定为 true
        dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i ++) {
            int num = nums[i];
            for (int t = 1; t < targetSum + 1; t ++) {
                if (t < num) {
                    dp[i][t] = dp[i - 1][t];
                } else {
                    dp[i][t] = dp[i - 1][t] | dp[i - 1][t - num];
                }
            }
        }
        return dp[dp.length - 1][targetSum];
    }

}
