package com.leetcode.practice.solutions.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 45, 1231, 213, 33, 55, 221231, 100000};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    public static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        // 将数组分割成两部份
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        // 排序
        merge(nums, start, end);
    }

    public static void merge(int[] nums, int start, int end) {
        int[] temp = new int[end - start + 1];
        int mid = (start + end) / 2;
        int i = start, j = mid + 1;
        int tempIndex = 0;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[tempIndex++] = nums[i++];
            } else {
                temp[tempIndex++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[tempIndex++] = nums[i++];
        }
        while (j <= end) {
            temp[tempIndex++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, start, temp.length);
    }
}
