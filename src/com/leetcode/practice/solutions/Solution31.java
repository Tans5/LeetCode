package com.leetcode.practice.solutions;

import java.util.Arrays;

public class Solution31 {

    public static void nextPermutation(int[] nums) {
        int temp;
        for (int i = nums.length - 1; i > 0; i --) {
            if (nums[i] > nums[i - 1]) {
                int startIndex = i - 1;
                int endIndex = i;
                for (int j = endIndex + 1; j < nums.length; j ++) {
                    if (nums[j] > nums[startIndex]) {
                        endIndex = j;
                    }
                }
                temp = nums[startIndex];
                nums[startIndex] = nums[endIndex];
                nums[endIndex] = temp;
                int[] copy = Arrays.copyOfRange(nums, i, nums.length);
                Arrays.sort(copy);
                System.arraycopy(copy, 0, nums, i, copy.length);
                return;
            }
        }
        Arrays.sort(nums);
    }

}
