package com.leetcode.practice.solutions;

import java.util.*;

public class Solution39 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int sum = 0;
        Arrays.sort(candidates);
        pushResult(candidates, target, sum, queue, result);
        return result;
    }

    public static void pushResult(int[] nums, int target, int sum, PriorityQueue<Integer> queue, List<List<Integer>> result) {
        PriorityQueue<Integer> newQueue = new PriorityQueue<>(queue);
        for (int num: nums) {
            newQueue.offer(num);
            sum += num;
            if (sum == target) {
                List<Integer> newResult = new ArrayList<>(newQueue);
                if (!result.contains(newResult)) {
                    result.add(newResult);
                }
                break;
            }
            if (sum < target) {
                pushResult(nums, target, sum, newQueue, result);
                sum -= num;
                newQueue.remove(num);
            } else {
                break;
            }

        }
    }

}
