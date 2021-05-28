package com.leetcode.practice.solutions;

public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < result.length; i++) {
            for (int s = i + 1; s < result.length; s++) {
                if (temperatures[s] > temperatures[i]) {
                    result[i] = s - i;
                    break;
                }
            }
        }
        return result;
    }
}
