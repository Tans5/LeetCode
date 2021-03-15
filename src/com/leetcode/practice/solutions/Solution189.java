package com.leetcode.practice.solutions;

import java.util.Arrays;

public class Solution189 {

    public static void rotate(int[] nums, int k) {
        int size = nums.length;
        k = k % size;
        int[] origin = Arrays.copyOf(nums, size);
        for (int i = 0; i < size; i ++) {
            int index = i - k;
            if (index < 0) {
                index += size;
            }
            nums[i] = origin[index % size];
        }
    }
}
