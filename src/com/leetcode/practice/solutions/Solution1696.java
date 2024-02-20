package com.leetcode.practice.solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1696 {
    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || k <= 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = nums[0];


        // 以下方法实现超时
//        for (int i = 1; i < len; i ++) {
//            int startIndex = Math.max(0, i - k);
//            int endIndex = i;
//            int max = Integer.MIN_VALUE;
//            // 判断 [i - k, i) 跳转到 i 的最大值，结果就是 dp[i]。
//            for (int j = startIndex; j < endIndex; j ++) {
//                int temp = dp[j] + nums[i];
//                if (temp > max) {
//                    max = temp;
//                }
//            }
//            dp[i] = max;
//        }

        // 记录最大的 dp 的值和对应的 index
        PriorityQueue<Integer[]> maxValueQueueAndIndex = new PriorityQueue<Integer[]>(
                new Comparator<Integer[]>() {
                    @Override
                    public int compare(Integer[] o1, Integer[] o2) {
                        return o2[0] - o1[0];
                    }
                }
        );

        maxValueQueueAndIndex.add(new Integer[]{dp[0], 0});
        for (int i = 1; i < len; i ++) {
            int checkStartIndex = Math.max(0, i - k);
            // 移除超过 i - k 的最大值
            while (!maxValueQueueAndIndex.isEmpty() && maxValueQueueAndIndex.peek()[1] < checkStartIndex) {
                maxValueQueueAndIndex.poll();
            }
            dp[i] = nums[i] + maxValueQueueAndIndex.peek()[0];
            maxValueQueueAndIndex.add(new Integer[] {dp[i], i});
        }

        return dp[len - 1];
    }
}
