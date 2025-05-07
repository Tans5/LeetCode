package com.leetcode.practice.solutions.sort;

import java.util.Arrays;

public class HeepSort {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 45, 1231, 213, 33, 55, 221231, 100000};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void buildBigTopHeapFromTop(int[] nums, int fromIndex, int heapSize) {
        int i = fromIndex;
        while (true) {
            int leftChildIndex = i * 2 + 1;
            int rightChildIndex = leftChildIndex + 1;
            if (leftChildIndex >= heapSize) {
                break;
            } else {
                int value = nums[i];
                int leftChildValue = nums[leftChildIndex];
                if (rightChildIndex >= heapSize) {
                    if (value < leftChildValue) {
                        swap(nums, i, leftChildIndex);
                    }
                    break;
                } else {
                    int rightChildValue = nums[rightChildIndex];
                    if (value < leftChildValue && value < rightChildValue) {
                        if (leftChildValue >= rightChildValue) {
                            swap(nums, i, leftChildIndex);
                            i = leftChildIndex;
                        } else {
                            swap(nums, i, rightChildIndex);
                            i = rightChildIndex;
                        }
                    } else if (value < leftChildValue) {
                        swap(nums, i, leftChildIndex);
                        i = leftChildIndex;
                    } else if (value < rightChildValue) {
                        swap(nums, i, rightChildIndex);
                        i = rightChildIndex;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static void sort(int[] nums) {
        // 将原来的数组构建大顶堆
        for (int i = nums.length - 1; i >= 0; i --) {
            buildBigTopHeapFromTop(nums, i, nums.length);
        }

        // 将栈顶的元素和末尾的元素交换，然后再重新构建大顶堆
        for (int i = 0; i < nums.length; i ++) {
            // 将栈顶的元素和最后一个元素交换，此时数组末尾 i + 1 的元素已经完成排序，此时大顶堆也被破坏。
            swap(nums, 0, nums.length - i - 1);
            // 从 0 位置开始再构建大顶堆，这时堆的大小变成 nums.length - i - 1
            buildBigTopHeapFromTop(nums, 0, nums.length - i - 1);
        }
    }

}
