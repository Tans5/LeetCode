package com.leetcode.practice.solutions.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        for (int i = startIndex; i < candidates.length; i ++) {
            int n = candidates[i];
            if (n > target) {
                break;
            }
            state.add(n);
            backtracking(candidates, target - n, i, state, result);
            state.remove(state.size() - 1);
        }
    }
}
