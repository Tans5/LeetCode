package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < size - 2; i ++) {
            int focusIValue = nums[i];
            if (focusIValue > 0) {
                break;
            }
            int left = i + 1;
            int right = size - 1;
            if (i == 0 || nums[i] != nums[i-1]) {
                while (left < right) {
                    int value = focusIValue + nums[left] + nums[right];
                    if (value == 0) {
                        result.add(Arrays.asList(focusIValue, nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left ++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right --;
                        }
                        left ++;
                        right --;
                    } else if (value < 0) {
                        left ++;
                    } else {
                        right --;
                    }
                }
            }

        }
        return result;
    }
}
