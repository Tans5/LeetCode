package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Solution90 {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums.length < 1) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> numsList = new ArrayList<>();
        for (Integer i: nums) {
            numsList.add(i);
        }
        subset(numsList, new ArrayList<>(), result);
        return result;
    }

    public static void subset(List<Integer> nums, List<Integer> queue, List<List<Integer>> result) {
        if (nums.size() == 0) {
            return;
        }
        int lastNum = nums.get(0);
        List<Integer> newNums = new ArrayList<>(nums);
        for (int i = 0; i < nums.size(); i ++) {
            newNums.remove(nums.get(i));
            if (lastNum != nums.get(i) || i == 0) {
                lastNum = nums.get(i);
                List<Integer> newQueue = new ArrayList<>(queue);
                newQueue.add(lastNum);
                result.add(newQueue);
                subset(new ArrayList<>(newNums), newQueue, result);
            }
        }
    }
}
