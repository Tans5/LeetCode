package com.leetcode.practice.solutions.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
public class Solution216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private void backtracking(int start, int k, int n, List<Integer> state, List<List<Integer>> result) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(state));
            return;
        }
        if (start > 9) {
            return;
        }
        if (k == 0) {
            return;
        }
        if (n == 0) {
            return;
        }
        for (int i = start; i <= 9; i ++) {
            state.add(i);
            backtracking(i + 1, k - 1, n - i, state, result);
            state.remove(state.size() - 1);
        }
    }
}
