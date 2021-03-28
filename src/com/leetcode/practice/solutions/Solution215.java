package com.leetcode.practice.solutions;

import java.util.Arrays;

public class Solution215 {

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
//        if (nums.length < 1) {
//            return nums[0];
//        }
//
//        return sort(nums, 0, nums.length - 1, nums.length - k);
    }

    public static Integer sort(int[] nums, int start, int end, int targetIndex) {
        if (start < end) {
            int l = start;
            int r = end;
            int target = nums[l];
            while (l != r) {
                while (l < r && nums[r] > target) {
                    r --;
                }
                if (l < r) {
                    nums[l] = nums[r];
                    l ++;
                }
                while (l < r && nums[l] < target) {
                    l ++;
                }
                if (l < r) {
                    nums[r] = nums[l];
                    r --;
                }
            }
            nums[l] = target;
            if (l == targetIndex) {
                return target;
            } else {
                Integer result;
                if (targetIndex >= start && l - 1 >= targetIndex) {
                    result = sort(nums, start, l - 1, targetIndex);
                } else {
                    result = sort(nums, l + 1, end, targetIndex);
                }
                if (result != null) {
                    return result;
                } else {
                    return nums[targetIndex];
                }

            }
        } else {
            return null;
        }
    }


}
