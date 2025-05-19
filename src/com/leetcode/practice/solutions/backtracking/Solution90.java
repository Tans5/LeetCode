package com.leetcode.practice.solutions.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class Solution90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtracking(int[] nums, int startIndex, List<Integer> state, List<List<Integer>> result) {
        result.add(new ArrayList<>(state));
        if (startIndex >= nums.length) {
            return;
        }
        Integer lastTryNum = null;
        for (int i = startIndex; i < nums.length; i ++) {
            int n = nums[i];
            if (lastTryNum == null || n != lastTryNum) {
                lastTryNum = n;
                state.add(n);
                backtracking(nums, i + 1, state, result);
                state.remove(state.size() - 1);
            }
        }
    }
}
