package com.leetcode.practice.solutions;

public class Solution16_10 {

    public int maxAliveYear(int[] birth, int[] death) {
        int[] lives = new int[101];
        for (int i = 0; i < birth.length; i ++) {
            int startIndex = birth[i] - 1900;
            int endIndex = death[i] - 1900;
            for (int j = startIndex; j <= endIndex && j < lives.length; j ++) {
                lives[j] ++;
            }
        }
        int resultIndex = -1;
        int maxCount = 0;
        for (int i = 0; i < lives.length; i ++) {
            if (maxCount < lives[i]) {
                maxCount = lives[i];
                resultIndex = i;
            }
        }
        return resultIndex + 1900;
    }
}
