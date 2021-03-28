package com.leetcode.practice.solutions;

import java.util.Arrays;

public class Solution283 {

    public void moveZeroes(int[] nums) {
        int size = nums.length;
        int count = 0;
        for (int i = 0; i < size; i ++) {
            if (nums[i] != 0) {
                nums[count ++] = nums[i];
            }
        }
        Arrays.fill(nums, count, size, 0);
    }
}
