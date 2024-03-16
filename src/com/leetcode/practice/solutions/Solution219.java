package com.leetcode.practice.solutions;

public class Solution219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i ++) {
            int a = nums[i];
            for (int j = i + 1; (j < nums.length && j <= k + i); j ++) {
                if (nums[j] == a) {
                    return true;
                }
            }
        }
        return false;
    }
}
