package com.leetcode.practice.solutions.backtracking;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class Solution79 {

    public boolean exist(char[][] board, String word) {
        int rowSize = board.length;
        if (rowSize == 0) {
            return false;
        }
        int colSize = board[0].length;
        if (colSize == 0) {
            return false;
        }
        int size = rowSize * colSize;
        if (size < word.length()) {
            return false;
        }
        char[] wordChars = word.toCharArray();
        for (int row = 0; row < rowSize; row ++) {
            for (int col = 0; col < colSize; col ++) {
                if (backtracking(
                        board, rowSize, colSize, row, col,
                        wordChars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(
            char[][] board, int rowSize, int colSize, int row, int col,
            char[] word, int wordIndex) {
        if (wordIndex >= word.length) {
            return true;
        }
        if (row < 0 || col < 0 || row >= rowSize || col >= colSize) {
            return false;
        }
        char value = board[row][col];
        if (value != word[wordIndex] || value == '#') {
            return false;
        }
        if (wordIndex == word.length - 1) {
            return true;
        }
        board[row][col] = '#';
        int [] nextRoute = new int[] {
                row - 1, col, // 上
                row + 1, col, // 下
                row, col - 1, // 左
                row, col + 1  // 右
        };
        for (int i = 0; i < 4; i ++) {
            int r = nextRoute[i * 2];
            int c = nextRoute[i * 2 + 1];
            if (backtracking(
                    board, rowSize, colSize, r, c,
                    word, wordIndex + 1)) {
                return true;
            }
        }
        board[row][col] = value;
        return false;
    }
}
