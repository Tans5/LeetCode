package com.leetcode.practice.solutions.array;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组是数组中的一个连续部分。
 */
public class Solution53 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int a = max;
        for (int i = 1; i < nums.length; i ++) {
            a = Math.max(nums[i], nums[i] + a);
            if (a > max) {
                max = a;
            }
        }
        return max;
    }
}
