package com.leetcode.practice.solutions;

public class Solution581 {

    public int findUnsortedSubarray(int[] nums) {
        int size = nums.length;
        if (size <= 0) {
            return 0;
        }
        int l = 0;
        int r = size - 1;
        boolean stopL = false;
        boolean stopR = false;
        while (true) {
            if (l == r) {
                return 0;
            }
            int[] minAndMax = getMaxAndMin(nums, l, r);
            if (!stopL && nums[l] == minAndMax[0]) {
                l ++;
            } else {
                stopL = true;
            }
            if (!stopR && nums[r] == minAndMax[1]) {
                r --;
            } else {
                stopR = true;
            }
            if (stopL && stopR) {
                return r - l + 1;
            }
        }
    }
    public int[] getMaxAndMin(int[] nums, int start, int end) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i ++) {
            int n = nums[i];
            if (n > max) {
                max = n;
            }
            if (n < min) {
                min = n;
            }
        }
        return new int[]{min, max};
    }
}
