package com.leetcode.practice.solutions;

import java.util.Arrays;

public class Solution268 {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length + 1;
        int missing = -1;
        for (int i = 0; i < size; i ++) {
            if (i == size - 1) {
                missing = i;
                break;
            } else if(nums[i] != i) {
                missing = i;
                break;
            }
        }
        return missing;
    }
}
