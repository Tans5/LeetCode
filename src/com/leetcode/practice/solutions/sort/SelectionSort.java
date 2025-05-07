package com.leetcode.practice.solutions.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 45, 1231, 213, 33, 55, 221231, 100000};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        int min;
        for (int i = 0; i < nums.length; i ++) {
            min = nums[i];
            for (int j = i + 1; j < nums.length; j ++) {
                if (min > nums[j]) {
                    min = nums[j];
                }
            }
            nums[i] = min;
        }
    }

}
