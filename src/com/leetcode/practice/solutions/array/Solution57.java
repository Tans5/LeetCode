package com.leetcode.practice.solutions.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
 *
 * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
 *
 * 返回插入之后的 intervals。
 *
 * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 */
public class Solution57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[] toInsert = new int[] {newInterval[0], newInterval[1]};
        if (intervals.length == 0) {
            return new int[][] { toInsert };
        }
        List<int[]> result = new ArrayList<>();
        int i = 0;

        // 先将左侧的没有重合的部分先添加到结果中
        while (i < intervals.length && toInsert[0] > intervals[i][1]) {
            result.add(new int[] {intervals[i][0], intervals[i][1]});
            i ++;
        }

        // 合并重合的部分
        while (i < intervals.length && intervals[i][0] <= toInsert[1]) {
            toInsert[0] = Math.min(intervals[i][0], toInsert[0]);
            toInsert[1] = Math.max(intervals[i][1], toInsert[1]);
            i ++;
        }
        result.add(toInsert);

        // 再将右侧没有重合的部分添加到结果中
        while (i < intervals.length) {
            result.add(new int[] {intervals[i][0], intervals[i][1]});
            i ++;
        }
        int[][] resultArray = new int[result.size()][2];
        result.toArray(resultArray);
        return resultArray;
    }


    public int[][] insert2(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }
        int[][] result = new int[intervals.length + 1][2];
        Integer toInsertLeft = newInterval[0];
        Integer toInsertRight = newInterval[1];
        int toInsertIndex = 0;
        int i = 0;
        while (toInsertIndex < result.length && i < intervals.length) {
            if (toInsertLeft != null) {
                // 移动 i 到 右边 >= toInsertLeft
                while (i < intervals.length && intervals[i][1] < toInsertLeft) {
                    result[toInsertIndex ++] = intervals[i ++];
                }
                if (i == intervals.length) {
                    result[toInsertIndex ++] = new int[] {toInsertLeft, toInsertRight};
                    break;
                }
                // 当前 i 的右边 >= toInsertLeft

                if (intervals[i][0] > toInsertRight) {
                    // 如果插入的区间没有和原来的区间重合
                    result[toInsertIndex ++] = new int[] {toInsertLeft, toInsertRight};
                } else {
                    // 取当前 i 的左边和插入的左边中的较小值作为新区间的左边
                    int left = Math.min(intervals[i][0], toInsertLeft);
                    // 移动 i 到右边 > toInsertRight
                    while (i < intervals.length && intervals[i][1] <= toInsertRight) {
                        i++;
                    }
                    if (i < intervals.length) {
                        if (intervals[i][0] <= toInsertRight) {
                            // 当前 i 的左边 <= toInsertRight
                            result[toInsertIndex ++] = new int[] {left, intervals[i][1]};
                            i ++;
                        } else {
                            result[toInsertIndex ++] = new int[] {left, toInsertRight};
                        }
                    } else {
                        result[toInsertIndex ++] = new int[] {left, toInsertRight};
                    }
                }
                toInsertLeft = null;
                toInsertRight = null;
            } else {
                result[toInsertIndex ++] = intervals[i ++];
            }
        }
        if (toInsertIndex == result.length) {
            return result;
        } else {
            int[][] fixResult = new int[toInsertIndex][2];
            System.arraycopy(result, 0, fixResult, 0, fixResult.length);
            return fixResult;
        }
    }
}
