package com.leetcode.practice.solutions.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 */
public class Solution22 {

    public List<String> generateParenthesis(int n) {
        char[] state = new char[n * 2];
        List<String> result = new ArrayList<>();
        backtracking(0, 0, n, state, 0, result);
        return result;
    }

    private void backtracking(
            int leftCount,
            int rightCount,
            int maxCount,
            char[] state,
            int stateIndex,
            List<String> result) {
        if (stateIndex >= state.length) {
            result.add(new String(state));
            return;
        }
        int toInsertLeftCount = maxCount - leftCount;
        int toInsertRightCount = maxCount - rightCount;
        if (toInsertLeftCount <= 0) {
            for (int i = 0; i < toInsertRightCount; i ++) {
                state[stateIndex ++] = ')';
                rightCount ++;
            }
            backtracking(leftCount, rightCount, maxCount, state, stateIndex, result);
        } else {
            // 两种选择插入左括号或者右括号

            // 左括号
            state[stateIndex] = '(';
            backtracking(leftCount + 1, rightCount, maxCount, state, stateIndex + 1, result);

            // 右括号
            if (rightCount < leftCount) {
                state[stateIndex] = ')';
                backtracking(leftCount, rightCount + 1, maxCount, state, stateIndex + 1, result);
            }
        }
    }
}
