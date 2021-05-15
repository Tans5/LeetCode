package com.leetcode.practice.solutions;

import java.util.Arrays;

public class FastSort {

    public static void main(String[] args) {
        int[] nums = new int[] {23, 1, 2, 5, 100, 250, 100, 200, 300, 1, 2, 3, 4, 5, 6};
        int[] nums2 = new int[] {1, 2, 3, 4, 5};
        fastSort(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void fastSort(int[] nums) {
        fastSort(nums, 0, nums.length - 1);
    }

    public static void fastSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int focusNum = nums[start];
        int left = start;
        int right = end;
        while (true) {
            while (left < right && nums[right] >= focusNum) {
                right --;
            }
            if (left >= right) {
                break;
            }
            nums[left] = nums[right];
            left ++;
            while (left < right && left < nums.length - 1 && nums[left] < focusNum) {
                left ++;
            }
            if (left >= right) {
                break;
            }
            nums[right] = nums[left];
            right --;
        }
        nums[left] = focusNum;
        fastSort(nums, start, left - 1);
        fastSort(nums, left + 1, end);
    }

}
