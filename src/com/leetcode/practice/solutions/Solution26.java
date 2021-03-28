package com.leetcode.practice.solutions;

public class Solution26 {
    public static int removeDuplicates(int[] nums) {

        if (nums.length < 1) {
            return 0;
        }

        int count = 1;

        for (int i = 0; i < nums.length; i ++) {
            if (i > 0) {
                if (nums[i] != nums[i - 1]) {
                    nums[count ++] = nums[i];

                }
            }
        }
        return count;
    }
}
