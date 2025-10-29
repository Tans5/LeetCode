package com.leetcode.practice.solutions.dynamicprograming;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class Solution300 {

    // [10,9,2,5,3,7,101,18]
    int lengthOfLIS(int[] nums) {
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
