package com.leetcode.practice.solutions;

public class Solution35 {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int start = 0;
        int end = len - 1;
        int result;
        while (true) {
            if (nums[start] >= target) {
                if (nums[start] == target) {
                    result = start;
                } else {
                    result = (start - 1 >= 0) ? (start - 1) : 0;
                }
                break;
            }
            if (nums[end] <= target) {
                if (nums[end] == target) {
                    result = end;
                } else {
                    result = end + 1;
                }
                break;
            }
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                result = mid;
                break;
            }
            if (start + 1 == end) {
                result = end;
                break;
            }
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return result;
    }
}
