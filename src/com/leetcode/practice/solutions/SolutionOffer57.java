package com.leetcode.practice.solutions;

public class SolutionOffer57 {

    public int[] twoSum(int[] nums, int target) {
        if (nums.length <= 1) {
            return new int[0];
        }
        int leftNum = nums[0];
        for (int i = 0; i < nums.length - 1; i ++) {
            if (i == 0 || nums[i] != leftNum) {
                leftNum = nums[i];
                if (containTarget(nums, i + 1, target - leftNum)) {
                    return new int[] {leftNum, target - leftNum};
                }
            }
        }
        return new int[0];
    }
    public boolean containTarget(int[] nums, int startIndex, int target) {
        int start = startIndex;
        int end = nums.length;
        int mid;
        while (true) {
            mid = (end + start) / 2;
            int num = nums[mid];
            if (num == target) {
                return true;
            }
            if (num > target) {
                if (end != mid) {
                    end = mid;
                } else {
                    return false;
                }
            }
            if (num < target) {
                if (start != mid) {
                    start = mid;
                } else {
                    return false;
                }
            }

        }
    }

}
