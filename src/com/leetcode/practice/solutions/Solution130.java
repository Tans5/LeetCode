package com.leetcode.practice.solutions;

public class Solution130 {
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        if (board[0].length == 0) {
            return;
        }
        int maxRow = board.length;
        int maxCol = board[0].length;
        boolean[][] protect = new boolean[board.length][board[0].length];
        // row check.
        int firstRow = 0;
        int lastRow = maxRow - 1;
        for (int i = 0; i < maxCol; i ++) {
            if (board[firstRow][i] == 'O') {
                if (!protect[firstRow][i]) {
                    protect(firstRow, i, board, protect);
                }
            }
        }
        if (lastRow > firstRow) {
            for (int i = 0; i < maxCol; i ++) {
                if (board[lastRow][i] == 'O') {
                    if (!protect[lastRow][i]) {
                        protect(lastRow, i, board, protect);
                    }
                }
            }
        }
        // col check;
        int firstCol = 0;
        int lastCol = maxCol - 1;
        for (int i = 0; i < maxRow; i ++) {
            if (board[i][firstCol] == 'O') {
                if (!protect[i][firstCol]) {
                    protect(i, firstCol, board, protect);
                }
            }
        }
        if (lastCol > firstCol) {
            for (int i = 0; i < maxRow; i ++) {
                if (board[i][lastCol] == 'O') {
                    if (!protect[i][lastCol]) {
                        protect(i, lastCol, board, protect);
                    }
                }
            }
        }
        for (int r = 0; r < maxRow; r ++) {
            for (int c = 0; c < maxCol; c ++) {
                if (board[r][c] == 'O' && !protect[r][c]) {
                    board[r][c] = 'X';
                }
            }
        }
    }

    public void protect(int r, int c, char[][] board, boolean[][] protect) {
        if (r >= board.length || r < 0) {
            return;
        }
        if (c >= board[0].length || c < 0) {
            return;
        }
        if (protect[r][c]) {
            return;
        }
        if (board[r][c] == 'O') {
            protect[r][c] = true;
            protect(r, c + 1, board, protect);
            protect(r, c - 1, board, protect);
            protect(r + 1, c, board, protect);
            protect(r - 1, c, board, protect);
        }
    }
}
