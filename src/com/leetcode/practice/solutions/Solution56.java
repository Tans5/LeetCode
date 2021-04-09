package com.leetcode.practice.solutions;

import java.util.Arrays;

public class Solution56 {

    public static int[][] merge(int[][] intervals) {
        int[][] result = new int[0][];
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int start = -1;
        int end = -1;
        for (int i = 0; i < intervals.length; i ++) {
            if (i == 0) {
                start = intervals[i][0];
                end = intervals[i][1];
                continue;
            }
            if (intervals[i][0] > end) {
                result = appendNewItem(result, new int[] {start, Math.max(intervals[i - 1][1], end)});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }
        result = appendNewItem(result, new int[] { start, end });
        return result;
    }
    public static int[][] appendNewItem(int[][] origin, int[] newItem) {
        int[][] result = new int[origin.length + 1][];
        result[origin.length] = newItem;
        System.arraycopy(origin, 0, result, 0, origin.length);
        return result;
    }

}
