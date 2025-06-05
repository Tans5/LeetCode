package com.leetcode.practice.solutions.sort;

import java.util.Arrays;

public class BubbleSort {


    public static void main(String[] args) {
        int[] nums = new int[] {2, 45, 1231, 213, 33, 55, 221231, 100000};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        int temp;
        for (int sortedLen = 0; sortedLen < nums.length; sortedLen ++) {
            for (int i = 0; i < nums.length - sortedLen - 1; i ++) {
                if (nums[i] > nums[i + 1]) {
                    temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
    }

}
