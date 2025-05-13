package com.leetcode.practice.solutions.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 */
public class Solution77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(1, n, k , new ArrayList<>(), result);
        return result;
    }

    private void backtracking(int start, int end, int k, List<Integer> state, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(state));
            return;
        }
        if (start > end || (end - start + 1) < k) {
            return;
        }
        for (int i = start; i <= end; i ++) {
            state.add(i);
            backtracking(i + 1, end, k - 1, state, result);
            state.remove(state.size() - 1);
        }
    }
}
