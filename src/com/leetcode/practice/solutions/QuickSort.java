package com.leetcode.practice.solutions;

public class QuickSort {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int target = arr[start];
            int left = start;
            int right = end;
            while (left != right) {
                while (left < right && arr[right] > target) {
                    right --;
                }
                if (left < right) {
                    arr[left] = arr[right];
                    left ++;
                }
                while (left < right && arr[left] < target) {
                    left ++;
                }
                if (left < right) {
                    arr[right] = arr[left];
                    right --;
                }
            }
            arr[left] = target;
            if (start < left - 1) {
                sort(arr, start, left - 1);
            }
            if (left + 1 < end) {
                sort(arr, left + 1, end);
            }
        }
    }
}
