package com.leetcode.practice.solutions;

public class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int firstIndex = 0;
        int lastIndex = flowerbed.length - 1;
        for (int i = 0; i < flowerbed.length; i ++) {
            if (n <= 0) {
                break;
            }
            int currentValue = flowerbed[i];
            int lastValue = -1;
            if (i > firstIndex) {
                lastValue = flowerbed[i - 1];
            }
            int nextValue = -1;
            if (i < lastIndex) {
                nextValue = flowerbed[i + 1];
            }
            if (lastValue == 1) {
                continue;
            }
            if (nextValue == 1) {
                continue;
            }
            if (currentValue == 1) {
                continue;
            }
            n --;
            flowerbed[i] = 1;
        }

        return n <= 0;
    }
}
