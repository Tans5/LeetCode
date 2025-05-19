package com.leetcode.practice.solutions.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtracking(int[] nums, int startIndex, List<Integer> state, List<List<Integer>> result) {
        result.add(new ArrayList<>(state));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i ++) {
            state.add(nums[i]);
            backtracking(nums, i + 1, state, result);
            state.remove(state.size() - 1);
        }
    }
}
