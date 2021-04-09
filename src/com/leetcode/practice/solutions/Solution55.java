package com.leetcode.practice.solutions;

import java.util.ArrayDeque;

public class Solution55 {


    public static boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i ++) {
            for (int j = i - 1; j >= 0; j --) {
                if (dp[j] && nums[j] >= i - j) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }

}
