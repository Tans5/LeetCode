package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 1) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> numList = new ArrayList<>();
        for (Integer n: nums) {
            numList.add(n);
        }
        fill(numList, new ArrayList<>(), result);
        return result;
    }

    public void fill(List<Integer> nums, List<Integer> queue, List<List<Integer>> result) {
        if (nums.size() < 1) {
            result.add(queue);
            return;
        }
        int lastEnqueueNum = nums.get(0);
        for (int i = 0; i < nums.size(); i ++) {
            if (nums.get(i) != lastEnqueueNum || i == 0) {
                lastEnqueueNum = nums.get(i);
                List<Integer> newQueue = new ArrayList<>(queue);
                newQueue.add(lastEnqueueNum);
                List<Integer> newNums = new ArrayList<>(nums);
                newNums.remove(i);
                fill(newNums, newQueue, result);
            }
        }
    }

}
