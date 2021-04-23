package com.leetcode.practice.solutions;

public class Solution674 {

    public int findLengthOfLCIS(int[] nums) {
        int maxLen = 1;
        for (int i = 0; i < nums.length - 1; i ++) {
            int len = 1;
            while (i < nums.length - 1 && nums[i + 1] > nums[i]) {
                i ++;
                len ++;
            }
            if (len > maxLen) {
                maxLen = len;
            }
        }
        return maxLen;
    }
}
