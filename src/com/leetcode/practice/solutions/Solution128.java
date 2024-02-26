package com.leetcode.practice.solutions;

import java.util.Arrays;

public class Solution128 {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int maxLong = 1;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i ++) {
            int a = nums[i];
            int b = nums[i + 1];
            if (a == b) {
                continue;
            }
            if ((b - a) == 1) {
                count ++;
                if (count > maxLong) {
                    maxLong = count;
                }
            } else {
                count = 1;
            }
        }
        return maxLong;
    }
}
