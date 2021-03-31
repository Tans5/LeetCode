package com.leetcode.practice.solutions;

import java.util.Arrays;

public class Solution503 {

    public int[] nextGreaterElements(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        Arrays.fill(result, -1);
        int j;
        for (int i = 0; i < size; i ++) {
            j = (i + 1) % size;
            while (j != i) {
                if (nums[i] < nums[j]) {
                    result[i] = nums[j];
                    break;
                } else {
                    j = (j + 1) % size;
                }
            }
        }

        return result;
    }

}
