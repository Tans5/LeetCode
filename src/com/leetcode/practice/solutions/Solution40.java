package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution40 {
    public int[] solution(int[] arr, int k) {
        if (arr.length < k) {
            return new int[] {};
        }
        int[] result = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i ++) {
            result[i] = arr[i];
        }
        return result;
    }
}
