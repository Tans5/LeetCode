package com.leetcode.practice.solutions;

public class Solution875 {

    public static int minEatingSpeed(int[] piles, int h) {
        int size = piles.length;
        if (size > h) {
            return -1;
        }
        if (canFinish(piles, h, 1)) {
            return 1;
        }
        int minS = 1;
        int maxS = Integer.MIN_VALUE;
        for (int p: piles) {
            if (p > maxS) {
                maxS = p;
            }
        }
        int result = maxS;
        int mid;
        while (maxS - minS > 1) {
            mid = (maxS + minS) / 2;
            if (canFinish(piles, h, mid)) {
                result = mid;
                maxS = mid;
            } else {
                minS = mid;
            }
        }

        return result;
    }

    public static boolean canFinish(int[] piles, int h, int s) {
        int useTime = 0;
        for (int p: piles) {
            if (p < s) {
                useTime ++;
            } else if (p % s == 0) {
                useTime += p / s;
            } else {
                useTime += p / s + 1;
            }
            if (useTime > h) {
                return false;
            }
        }
        return true;
    }

}
