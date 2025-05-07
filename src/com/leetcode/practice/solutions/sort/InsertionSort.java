package com.leetcode.practice.solutions.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 45, 1231, 213, 33, 55, 221231, 100000};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        int size = nums.length;
        if (size < 2) {
            return;
        }
        int toInsert;
        for (int i = 1; i < size; i ++) {
            toInsert = nums[i];
            int j = i;
            while (j > 0) {
                if (nums[j] < toInsert) {
                    break;
                }
                j --;
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = toInsert;
        }
    }
}
