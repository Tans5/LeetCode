package com.leetcode.practice.solutions;

import java.util.Arrays;

public class HeepSort {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 45, 1231, 213, 33, 55, 221231, 100000};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        int temp;
        for (int i = nums.length - 1; i > 0; i --) {
            buildBigTopHeep(nums, i);
            temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
        }
    }

    public static void buildBigTopHeep(int[] nums, int end) {
        int temp;
        for (int i = end; i > 0; i --) {
            if (nums[i] > nums[(i - 1) / 2]) {
                temp = nums[i];
                nums[i] = nums[(i - 1) / 2];
                nums[(i - 1) / 2] = temp;
            }
        }

    }

}
