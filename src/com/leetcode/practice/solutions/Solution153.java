package com.leetcode.practice.solutions;

import java.util.Arrays;

public class Solution153 {

    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;
        int result;
        int mid;
        while (true) {
            mid = (end + start) / 2;
            if (nums[mid] > nums[end]) {
                if (mid + 1 == end) {
                    result = nums[end];
                    break;
                }
                start = mid;
            } else {
                end = mid;
            }
        }

        return result;
    }
}
