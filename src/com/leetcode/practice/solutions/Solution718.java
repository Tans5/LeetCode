package com.leetcode.practice.solutions;

public class Solution718 {

    public int findLength(int[] nums1, int[] nums2) {
        int maxLen = 0;
        for (int offset = 0; offset < nums1.length - 1; offset ++) {
            int len = computeMaxOffset(nums1, nums2, offset);
            if (len > maxLen) {
                maxLen = len;
            }
        }

        for (int offset = 0; offset < nums2.length - 1; offset ++) {
            int len = computeMaxOffset(nums2, nums1, offset);
            if (len > maxLen) {
                maxLen = len;
            }
        }
        return maxLen;
    }

    public int computeMaxOffset(int[] longNums, int[] sortNums, int offset) {
        int maxLen = 0;
        int size = Math.min(longNums.length - offset, sortNums.length);
        for (int i = 0; i < size; i ++) {
            int len = 0;
            while (i < size && longNums[offset + i] == sortNums[i]) {
                len ++;
                i ++;
            }
            if (len > maxLen) {
                maxLen = len;
            }
        }
        return maxLen;
    }

}
