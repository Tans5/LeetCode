package com.leetcode.practice.solutions.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {


    public List<List<Integer>> subsetSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, target, new ArrayList<>(), 0, result);
        return result;
    }

    private void backtracking(int[] nums, int target, List<Integer> state, int startIndex, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(state));
            return;
        }
        for (int i = startIndex; i < nums.length; i ++) {
            if (nums[i] > target) {
                break;
            }
            state.add(nums[i]);
            target -= nums[i];
            backtracking(nums, target, state, i, result);
            state.remove(state.size() - 1);
            target += nums[i];
        }
    }
}
