package com.leetcode.practice.solutions;

public class Solution80 {
    public static int removeDuplicates(int[] nums) {
        int size = nums.length;
        int focus = nums[0];
        int focusHitTimes = 0;
        for (int i = 0; i < size; i++) {
            if (nums[i] == focus) {
                if (focusHitTimes >= 2) {
                    removeIndex(nums, i, size);
                    size --;
                    i --;
                } else {
                    focusHitTimes ++;
                }
            } else {
                focus = nums[i];
                focusHitTimes = 1;
            }
        }
        return size;
    }

    public static void removeIndex(int[] nums, int index, int size) {
        if (size - 1 - index >= 0) System.arraycopy(nums, index + 1, nums, index, size - 1 - index);
    }
}
