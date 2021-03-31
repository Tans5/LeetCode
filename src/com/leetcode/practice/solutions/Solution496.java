package com.leetcode.practice.solutions;

import java.util.Arrays;

public class Solution496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int[] result = new int[size1];
        Arrays.fill(result, -1);
        int focusIndex;
        for (int i = 0; i < size1; i ++) {
            focusIndex = indexOf(nums2, nums1[i]);
            for (int j = focusIndex + 1; j < size2; j ++) {
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        return result;
    }

    public int indexOf(int[] nums, int num) {
        int result = -1;
        for(int i = 0; i < nums.length; i ++) {
            if (nums[i] == num) {
                result = i;
                break;
            }
        }
        return result;
    }

}
