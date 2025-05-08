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
        for (int i = 1; i < counter.length; i ++) {
            counter[i] += counter[i - 1];
        }
        int[] sorted = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i --) {
            int num = nums[i];
            sorted[--counter[num]] = num;
        }
        System.arraycopy(sorted, 0, nums, 0, sorted.length);
    }

}
