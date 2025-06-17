package com.leetcode.practice.solutions.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }
        Arrays.sort(intervals, (a, b) -> { return a[0] - b[0]; });
        int i = 0;
        List<int[]> resultList = new ArrayList<>();
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            do {
                if (intervals[i][1] > right) {
                    right = intervals[i][1];
                }
                i ++;
            } while(i < intervals.length && intervals[i][0] <= right);
            resultList.add(new int[] {left, right});
        }
        int[][] result = new int[resultList.size()][2];
        for (int j = 0; j < result.length; j ++) {
            result[j] = resultList.get(j);
        }
        return result;
    }
}
