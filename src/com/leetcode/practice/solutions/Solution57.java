package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution57 {
    public static int[][] findContinuousSequence(int target) {
        if (target <= 2) {
            return new int[][]{};
        }
        List<int[]> result = new ArrayList<>();
        int sum = 0;
        int start = 1;
        int end = 1;
        while (start <= target / 2 && end < target) {
            if (sum < target) {
                sum += end;
                end ++;
            } else if (sum > target) {
                sum -= start;
                start ++;
            } else {
                int[] item = new int[end - start];
                for (int i = start; i < end; i ++) {
                    item[i - start] = i;
                }
                result.add(item);
                sum -= start;
                start ++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
