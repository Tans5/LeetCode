package com.leetcode.practice.solutions;

public class Solution845 {

    public int longestMountain(int[] arr) {
        int maxLen = 0;
        for (int i = 0; i < arr.length - 1; i ++) {
            int upLen = 0;
            int downLen = 0;
            while (i < arr.length - 1 && arr[i] < arr[i + 1]) {
                i ++;
                upLen ++;
            }
            if (upLen > 0) {
                while (i < arr.length - 1 && arr[i] > arr[i + 1]) {
                    i ++;
                    downLen ++;
                }
                if (downLen > 0 && upLen + downLen + 1 > maxLen) {
                    maxLen = upLen + downLen + 1;
                }
                i --;
            }
        }
        return maxLen;
    }
}
