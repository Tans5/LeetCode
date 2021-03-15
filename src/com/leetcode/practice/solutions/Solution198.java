package com.leetcode.practice.solutions;

public class Solution198 {

    public static int rob(int[] nums) {
        int size = nums.length;
        int[][] dp = new int[size][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        int max;
        for (int i = 1; i < size; i ++) {
            int value = nums[i];
            int lastValue = dp[i - 1][0];
            int lastIndex = dp[i - 1][1];
            if (i - lastIndex > 1) {
                dp[i][0] = lastValue + value;
                dp[i][1] = i;
            } else {
                max = Integer.MIN_VALUE;
                for (int j = 0; j < i; j ++) {
                    int index = dp[j][1];
                    if (i - index > 1) {
                        if (value + dp[j][0] > max) {
                            max = value + dp[j][0];
                            dp[i][0] = max;
                            dp[i][1] = i;
                        }
                    } else {
                        if (value > dp[j][0]) {
                            if (value > max) {
                                max = value;
                                dp[i][0] = max;
                                dp[i][1] = i;
                            }
                        } else {
                            if (dp[j][0] > max) {
                                max = dp[j][0];
                                dp[i][0] = max;
                                dp[i][1] = j;
                            }
                        }
                    }
                }
            }
        }
        return dp[size - 1][0];
    }
}
