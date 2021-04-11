package com.leetcode.practice.solutions;

public class Solution238 {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] dpL = new int[nums.length - 1];
        int[] dpR = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i ++) {
            if (i == 0) {
                dpL[0] = nums[i];
            } else {
                dpL[i] = dpL[i - 1] * nums[i];
            }
        }
        for (int i = 0; i < nums.length - 1; i ++) {
            if (i == 0) {
                dpR[0] = nums[nums.length - 1 - i];
            } else {
                dpR[i] = dpR[i - 1] * nums[nums.length - 1 - i];
            }
        }
        for (int i = 0; i < nums.length; i ++) {
            if (i == 0) {
                result[i] = dpR[nums.length - i - 2];
            } else if (i == nums.length - 1) {
                result[i] = dpL[i - 1];
            } else {
                result[i] = dpL[i - 1] * dpR[nums.length - i - 2];
            }
        }
        return result;
    }

}
