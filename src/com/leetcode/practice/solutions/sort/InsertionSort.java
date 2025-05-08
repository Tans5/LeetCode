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
        for (int sortedSize = 1; sortedSize < size; sortedSize ++) {
            toInsert = nums[sortedSize];
            int i = sortedSize - 1;
            do {
                if (nums[i] <= toInsert) {
                    break;
                }
                nums[i + 1] = nums[i];
                i --;
            } while (i >= 0);
            i ++;
            nums[i] = toInsert;
        }
    }
}
