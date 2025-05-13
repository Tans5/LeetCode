package com.leetcode.practice.solutions.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 */
public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtracking(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtracking(int[] candidates, int target, int startIndex, List<Integer> state, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(state));
            return;
        }
        int lastTryNum = -1;
        for (int i = startIndex; i < candidates.length; i ++) {
            int n = candidates[i];
            if (n > target) {
                break;
            }
            if (lastTryNum != n) {
                lastTryNum = n;
                state.add(n);
                backtracking(candidates, target - n, i + 1, state, result);
                state.remove(state.size() - 1);
            }
        }
    }
}
