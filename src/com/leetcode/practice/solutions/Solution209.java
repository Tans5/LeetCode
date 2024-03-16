package com.leetcode.practice.solutions;

public class Solution209 {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] > target ? 1 : 0;
        }
        int minLen = Integer.MAX_VALUE;
        int size = nums.length;
        int left = 0;
        int right = 0;
        int sum = nums[0];
        while (left <= right && right < size) {
            if (sum >= target) {
                int len = right - left + 1;
                if (len < minLen) {
                    minLen = len;
                }
                if (len == 1) {
                    left ++;
                    right ++;
                    if (left < size) {
                        sum = nums[left];
                    }
                } else {
                    sum -= nums[left];
                    left ++;
                }
            } else {
                right ++;
                if (right < size) {
                    sum += nums[right];
                }
            }

        }

        if (minLen == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLen;
        }
    }
}
