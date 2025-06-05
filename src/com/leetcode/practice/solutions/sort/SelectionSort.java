package com.leetcode.practice.solutions.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 45, 1231, 213, 33, 55, 221231, 100000};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        int minIndex;
        int temp;
        for (int sortedLen = 0; sortedLen < nums.length; sortedLen ++) {
            minIndex = sortedLen;
            for (int i = sortedLen + 1; i < nums.length; i ++) {
                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }
            if (minIndex != sortedLen) {
                temp = nums[sortedLen];
                nums[sortedLen] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }

}
