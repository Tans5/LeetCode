package com.leetcode.practice.solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int size = nums.length;
        int resultSize = size - k + 1;
        int[] result = new int[resultSize];
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < k; i ++) {
            queue.offer(new Integer[] {nums[i], i});
        }
        result[0] = queue.peek()[0];
        for (int i = k; i < size; i ++) {
            queue.offer(new Integer[] {nums[i], i});
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            result[i - k + 1] = queue.peek()[0];
        }
        return result;
    }
}
