package com.leetcode.practice.solutions.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class Solution51_2 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        // 列忽略
        boolean[] colIgnore = new boolean[n];
        // 主对角线忽略
        boolean[] mainDiagonalIgnore = new boolean[2 * n];
        // 次对角线忽略
        boolean[] subDiagonalIgnore = new boolean[ 2 * n];
        List<Integer> state = new ArrayList<>();
        byte[] lineBuffer = new byte[n];
        Arrays.fill(lineBuffer, (byte) '.');
        solveNQueens(n, 0, state, colIgnore, mainDiagonalIgnore, subDiagonalIgnore, lineBuffer, result);
        return result;
    }

    private void solveNQueens(
            int n,
            int row,
            List<Integer> state,
            boolean[] colIgnore,
            boolean[] mainDiagonalIgnore,
            boolean[] subDiagonalIgnore,
            byte[] lineBuffer,
            List<List<String>> result) {
        if (row == n) {
            List<String> sMap = new ArrayList<>();
            for (int i = 0; i < n; i ++) {
                int qi = state.get(i);
                lineBuffer[qi] = 'Q';
                sMap.add(new String(lineBuffer));
                lineBuffer[qi] = '.';
            }
            result.add(sMap);
            return;
        }
        for (int col = 0; col < n; col ++) {
            // 主对角线的元素 row - col 是一个恒定的值，为了让这个值一定大于等于 0，所以加 n - 1.
            int mainDiagonalIndex = row - col + n - 1;
            // 次对角线的元素 row + col 是一个恒定的值.
            int subDiagonalIndex = row + col;
            if (!colIgnore[col] && !mainDiagonalIgnore[mainDiagonalIndex] && !subDiagonalIgnore[subDiagonalIndex]) {
                colIgnore[col] = true;
                mainDiagonalIgnore[mainDiagonalIndex] = true;
                subDiagonalIgnore[subDiagonalIndex] = true;
                state.add(col);
                solveNQueens(n, row + 1, state, colIgnore, mainDiagonalIgnore, subDiagonalIgnore, lineBuffer, result);
                colIgnore[col] = false;
                mainDiagonalIgnore[mainDiagonalIndex] = false;
                subDiagonalIgnore[subDiagonalIndex] = false;
                state.remove(state.size() - 1);
            }
        }
    }

}
