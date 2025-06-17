package com.leetcode.practice.solutions.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class Solution347 {

    public int[] topKFrequent(int[] nums, int k) {
        // key: num, value: times
        Map<Integer, Integer> numTimes = new HashMap<>();
        for (int n: nums) {
            numTimes.put(n, numTimes.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> { return b[1] - a[1];});
        for (Map.Entry<Integer, Integer> entry: numTimes.entrySet()) {
            priorityQueue.add(new int[] {entry.getKey(), entry.getValue()});
        }
        int [] result = new int[k];
        for (int i = 0; i < k; i ++) {
            result[i] = priorityQueue.poll()[0];
        }
        return result;
    }
}
