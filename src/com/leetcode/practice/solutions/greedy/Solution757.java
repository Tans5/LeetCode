package com.leetcode.practice.solutions.greedy;

import java.util.Arrays;

/**
 * 给你一个二维整数数组 intervals ，其中 intervals[i] = [starti, endi] 表示从 starti 到 endi 的所有整数，包括 starti 和 endi 。
 *
 * 包含集合 是一个名为 nums 的数组，并满足 intervals 中的每个区间都 至少 有 两个 整数在 nums 中。
 *
 * 例如，如果 intervals = [[1,3], [3,7], [8,9]] ，那么 [1,2,4,7,8,9] 和 [2,3,4,8,9] 都符合 包含集合 的定义。
 * 返回包含集合可能的最小大小。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[3,7],[8,9]]
 * 输出：5
 * 解释：nums = [2, 3, 4, 8, 9].
 * 可以证明不存在元素数量为 4 的包含集合。
 *
 * 1 <= intervals.length <= 3000
 * intervals[i].length == 2
 * 0 <= starti < endi <= 108
 */
public class Solution757 {

    // [[11,24],[12,25],[2,8],[14,25],[10,23]]
    public int intersectionSizeTwo(int[][] intervals) {

        // 将区间排序，区间结束点升序，起始点降序
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return b[0] - a[0];
            }
        });
        // 取第一个区间的第二大的值和最大的值作为集合的默认两个元素；后续循环增加这个集合，但是只保留集合中国呢的最大的两个元素。
        int leftMax = -2;
        int rightMax = -1;
        int count = 0;
        for (int[] interval : intervals) {
            if (interval[0] > rightMax) {
                // 当前区间的最小值都大于区间的最大值，所以要增加两个元素。
                leftMax = interval[1] - 1;
                rightMax = interval[1];
                count += 2;
            } else if (interval[0] > leftMax) {
                // 当前区间的最小值大于区间中第二大的值，所以需要增加一个元素
                leftMax = rightMax;
                rightMax = interval[1];
                count++;
            }
            // 其他情况，包括在区间中
        }
        return count;
    }
}
