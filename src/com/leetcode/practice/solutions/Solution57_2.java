package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution57_2 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }
        if (newInterval.length == 0) {
            return intervals;
        }
        List<int[]> resultList = new ArrayList<>();
        Integer rangeStart = null;
        boolean waitEnding = false;
        boolean insertDone = false;
        for (int i = 0; i < intervals.length; i ++) {
            int[] range = intervals[i];
            if (!insertDone && range[1] >= newInterval[0]) {
                if (!waitEnding) {
                    waitEnding = true;
                    rangeStart = Math.min(newInterval[0], range[0]);
                }
            }
            if (waitEnding) {
                if (range[1] >= newInterval[1]) {
                    if (range[0] <= newInterval[1]) {
                        resultList.add(new int[] {rangeStart, range[1]});
                    }
                    if (range[0] > newInterval[1]) {
                        resultList.add(new int[] {rangeStart, newInterval[1]});
                        resultList.add(range);
                    }
                    waitEnding = false;
                    insertDone = true;
                }
            } else {
                resultList.add(range);
            }
        }
        if (!insertDone) {
            if (rangeStart == null) {
                resultList.add(newInterval);
            } else {
                resultList.add(new int[] {rangeStart, newInterval[1]});
            }
            insertDone = true;
            waitEnding = false;
        }

        int[][] result = new int[resultList.size()][];
        for (int i = 0; i < resultList.size(); i ++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
