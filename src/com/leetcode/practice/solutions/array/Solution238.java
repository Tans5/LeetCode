package com.leetcode.practice.solutions.array;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class Solution238 {

    public int[] productExceptSelf(int[] nums) {
        int[] dpL = new int[nums.length];
        int[] dpR = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            if (i == 0) {
                dpL[i] = nums[i];
            } else {
                dpL[i] = nums[i] * dpL[i - 1];
            }
            int rI = nums.length - i - 1;
            if (i == 0) {
                dpR[i] = nums[rI];
            } else {
                dpR[i] = nums[rI] * dpR[i - 1];
            }
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            int leftMulti = 1;
            int rightMulti = 1;
            if (i > 0) {
                leftMulti = dpL[i - 1];
            }
            if (i < nums.length - 1) {
                rightMulti = dpR[nums.length - i - 2];
            }
            result[i] = leftMulti * rightMulti;
        }
        return result;
    }
}
