package com.leetcode.practice.solutions;


public class Solution79 {

    public boolean exist(char[][] board, String word) {
        if (word.isEmpty()) {
            return true;
        }
        char[] chars = word.toCharArray();
        boolean[][] visitedPosition = new boolean[board.length][board[0].length];

        for (int r = 0; r < board.length; r ++) {
            for (int c = 0; c < board[r].length; c ++) {
                if (route(board, chars, r, c, 0, visitedPosition)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean route(
            char[][] board,
            char[] chars,
            int row,
            int col,
            int startIndex,
            boolean[][] visitedPosition) {
        if (startIndex >= chars.length) {
            return true;
        }
        if (board.length <= row || row < 0) {
            return false;
        }
        if (board[row].length <= col || col < 0) {
            return false;
        }
        if (!visitedPosition[row][col]) {
            if (board[row][col] == chars[startIndex]) {
                visitedPosition[row][col] = true;
                boolean isOk;
                isOk = route(board, chars, row, col + 1, startIndex + 1, visitedPosition);
                if (isOk) {
                    return true;
                }
                isOk = route(board, chars, row, col - 1, startIndex + 1, visitedPosition);
                if (isOk) {
                    return true;
                }
                isOk = route(board, chars, row - 1, col, startIndex + 1, visitedPosition);
                if (isOk) {
                    return true;
                }
                isOk = route(board, chars, row + 1, col, startIndex + 1, visitedPosition);
                if (isOk) {
                    return true;
                }
               visitedPosition[row][col] = false;
            } else {
                return false;
            }
        }
        return false;
    }
}
