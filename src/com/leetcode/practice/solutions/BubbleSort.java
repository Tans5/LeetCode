package com.leetcode.practice.solutions;

public class BubbleSort {

    public static void sort(int[] a) {
        int size = a.length;
        if (size < 2) {
            return;
        }
        int focus;
        for (int i = 1; i < size; i ++) {
            focus = a[i];
            for (int j = i - 1; j >= 0; j --) {
                if (a[j] > focus) {
                    a[j + 1] = a[j];
                    a[j] = focus;
                } else {
                    break;
                }
            }

        }
    }
}
