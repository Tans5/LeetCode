package com.leetcode.practice.solutions.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3, k = 3
 * 输出："213"
 * 示例 2：
 *
 * 输入：n = 4, k = 9
 * 输出："2314"
 */
public class Solution60 {

    public String getPermutation(int n, int k) {
        char[] result = new char[n];
        if (backtracking(n, k, new ArrayList<>(n), new boolean[n], result, new AtomicInteger(0))) {
            return new String(result);
        } else {
            return "";
        }
    }


    private boolean backtracking(int n, int k, List<Integer> state, boolean[] takenValue, char[] result, AtomicInteger times) {
        if (state.size() == n) {
            times.addAndGet(1);
            if (times.intValue() == k) {
                for (int i = 0; i < state.size(); i ++) {
                    result[i] = (char) ('0' + state.get(i));
                }
                return true;
            } else {
                return false;
            }
        }
        for (int num = 1; num <= n; num ++) {
            if (!takenValue[num - 1]) {
                takenValue[num - 1] = true;
                state.add(num);
                if (backtracking(n, k, state, takenValue, result, times)) {
                    return true;
                }
                takenValue[num - 1] = false;
                state.remove(state.size() - 1);
            }
        }

        return false;
    }
}
