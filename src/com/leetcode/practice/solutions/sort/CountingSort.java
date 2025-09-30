package com.leetcode.practice.solutions.sort;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 0, 1, 2, 0, 4, 0, 2, 2, 4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        int[] counter = new int[max + 1];
        for (int num : nums) {
            counter[num] ++;
        }
        int writeIndex = 0;
        for (int i = 0; i < counter.length; i ++) {
            for (int c = 0; c < counter[i]; c ++) {
                nums[writeIndex ++] = i;
            }
        }
    }

}
