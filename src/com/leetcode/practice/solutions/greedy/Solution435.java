package com.leetcode.practice.solutions.greedy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 *
 * 注意 只在一点上接触的区间是 不重叠的。例如 [1, 2] 和 [2, 3] 是不重叠的。
 *
 *
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 */
public class Solution435 {

    /**
     * 按结束点小的区间升序排序，然后按排序顺序异常加入新的队列，如果当前要入队列的区间的起始点小于上次入队列的终止点时当前的区间就不能入队列。
     * 区间中结束点越小的区间，对其他的区间的影响就越小，所以他们优先进入队列。
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });
        int count = 0;
        int[] lastEnqueue = intervals[0];
        for (int i = 1; i < intervals.length; i ++) {
            if (intervals[i][0] < lastEnqueue[1]) {
                count ++;
            } else {
                lastEnqueue = intervals[i];
            }
        }
        return count;
    }
}
