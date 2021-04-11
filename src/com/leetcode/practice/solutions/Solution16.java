package com.leetcode.practice.solutions;

public class Solution16 {


    public static int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        int close = Math.abs(result - target);
        for (int i = 0; i < nums.length - 2; i ++) {
            for (int j = i + 1; j < nums.length - 1; j ++) {
                for (int k = j + 1; k < nums.length; k ++) {
                    if (close > Math.abs((nums[i] + nums[j] + nums[k]) - target)) {
                        result = nums[i] + nums[j] + nums[k];
                        close = Math.abs(result - target);
                    }
                }
            }
        }
        return result;
    }
}
