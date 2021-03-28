package com.leetcode.practice.solutions;

public class Solution75 {
    public static void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int findIndex;
        while (true) {
            findIndex = -1;
            for (int i = start; i <= end; i ++) {
                if (nums[i] != 0) {
                    findIndex = i;
                    break;
                }
            }
            if (findIndex == -1) {
                break;
            } else {
                start = findIndex;
            }
            findIndex = -1;
            for (int i = end; i >= start; i --) {
                if (nums[i] != 2) {
                    findIndex = i;
                    break;
                }
            }
            if (findIndex == -1) {
                break;
            } else {
                end = findIndex;
            }
            if (start >= end) {
                break;
            }

            for (int i = start; i <= end; i ++) {
                if (nums[i] == 0) {
                    nums[i] = nums[start];
                    nums[start] = 0;
                    start ++;
                    break;
                }
                if (nums[i] == 2) {
                    nums[i] = nums[end];
                    nums[end] = 2;
                    end --;
                    break;
                }
                if (i == end) {
                    start = end;
                }
            }
        }
    }
}
