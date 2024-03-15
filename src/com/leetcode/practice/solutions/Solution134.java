package com.leetcode.practice.solutions;

public class Solution134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int size = gas.length;
        if (size == 0) {
            return -1;
        }
        if (cost.length != size) {
            return - 1;
        }
        int oil = 0;
        for (int startIndex = 0; startIndex < size;) {
            oil = gas[startIndex];
            for (int times = 1; times <= size; times ++) {
                int nextIndex = (startIndex + times) % size;
                int preIndex = nextIndex - 1;
                if (preIndex < 0) {
                    preIndex = size + preIndex;
                }
                if (oil >= cost[preIndex]) {
                    oil = oil - cost[preIndex] + gas[nextIndex];
                    if (nextIndex == startIndex) {
                        return startIndex;
                    }
                } else {
                    startIndex = startIndex + times;
                    break;
                }
            }
        }
        return -1;
    }
}
