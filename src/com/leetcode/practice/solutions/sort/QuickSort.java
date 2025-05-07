package com.leetcode.practice.solutions.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 45, 1231, 213, 33, 55, 221231, 100000};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void sort(int[] nums, int start, int end) {
        if (start >= end)
            return;

        int base = nums[start];
        int i = start;
        int j = end;
        // i 指向数组开始的位置，j 指向结束的位置。
        // 移动 i 和 j 向中间靠拢，最后 i = j，i 左边的数小于等于 base；右边的数大于等于 base.
        while (i < j) {
            // 将 j 移动到小于 base 的位置
            while (i < j && nums[j] >= base) {
                j --;
            }
            // 将 j 移动到大于 base 的位置
            while (i < j && nums[i] <= base) {
                i ++;
            }
            if (i != j) {
                // 此刻 i 的位置的值大于 base，j 位置的值小于 base，交换他们，进入下次循环
                swap(nums, i, j);
            }
        } // 移动完成后 i 位置的值一定是小于等于 base (必须是先移动右边才能够 i 位置的值小于等于 base)

        if (i != start) {
            // 此时 i 位置的值一定是小于等于 base 的，start 位置的值一定没有改变还是 base，将他们的值交换，保证 i 位置左边的值小于等于 base；
            // i 位置右边的值大于等于 base。
            swap(nums, i, start);
        }
        sort(nums, start, i - 1);
        sort(nums, i + 1, end);
    }

    public static void sort2(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int base = nums[end];
        while (i < j) {
            while (i < j && nums[i] <= base) {
                i ++;
            }
            while (i < j && nums[j] >= base) {
                j --;
            }
            swap(nums, i, j);
        }
        swap(nums, i, end);
        sort2(nums, start, i - 1);
        sort2(nums, i + 1, end);
    }
}
