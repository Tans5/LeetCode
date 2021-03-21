package com.leetcode.practice.solutions;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.util.Arrays;

public class Solution1033 {
    public static int[] solution(int a, int b, int c) {
        int[] arr = new int[] {a, b, c};
        Arrays.sort(arr);
        int dxy = arr[1] - arr[0];
        int dyz = arr[2] - arr[1];
        int max = dxy + dyz - 2;
        int min = 0;
        if (dxy == 2 && dyz > 1) {
            min = 1;
        } else if (dyz == 2 && dxy > 1) {
            min = 1;
        } else {
            if (dxy > 1) {
                min++;
            }
            if (dyz > 1) {
                min++;
            }
        }
        return new int[] {min, max};
    }
}
