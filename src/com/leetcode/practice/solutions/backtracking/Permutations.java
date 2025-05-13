package com.leetcode.practice.solutions.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private void backtracking(int[] nums, List<Integer> state, boolean[] choices, List<List<Integer>> result) {
        if (state.size() == nums.length) {
            result.add(new ArrayList<>(state));
            return;
        }
        HashSet<Integer> usedValue = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
            if (!choices[i] && !usedValue.contains(nums[i])) {
                choices[i] = true;
                usedValue.add(nums[i]);
                state.add(nums[i]);
                backtracking(nums, state, choices, result);
                choices[i] = false;
                state.remove(state.size() - 1);
            }
        }
    }
}
