package com.leetcode.practice.solutions;

public class Solution303 {

    public static void main(String[] args) {

    }
}

class NumArray {

    int[] sums;
    public NumArray(int[] nums) {
        sums = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            if (i == 0) {
                sums[i] = nums[i];
            } else {
                sums[i] = sums[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return sums[right];
        } else {
            return sums[right] - sums[left - 1];
        }
    }
}
