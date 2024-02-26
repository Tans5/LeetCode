package com.leetcode.practice.solutions;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int size = nums.length;
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            valueToIndex.put(nums[i], i);
        }
        for (int i = 0; i < size; i ++) {
            int a = nums[i];
            int b = target - a;
            Integer bi = valueToIndex.get(b);
            if (bi != null && bi > i) {
                result[0] = i;
                result[1] = bi;
                break;
            }
        }
        return result;
    }
}
