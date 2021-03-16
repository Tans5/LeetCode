package com.leetcode.practice.solutions;

public class Solution17 {

    public int[] printNumbers(int n) {
        int size = (int) Math.pow(10, n) - 1;
        int[] result = new int[size];
        for (int i = 0; i < size; i ++) {
            result[i] = i + 1;
        }
        return result;
    }
}
