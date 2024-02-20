package com.leetcode.practice.solutions;

public class Solution36 {

    public boolean isValidSudoku(char[][] board) {
        char[] rowCache = new char[9];
        char[] colCache = new char[9];
        char[] boxCache = new char[9];
        // row and col check.
        for (int i = 0; i < 9; i ++) {
            resetRouteCache(rowCache);
            resetRouteCache(colCache);
            resetRouteCache(boxCache);
            for (int j = 0; j < 9; j ++) {
                // row check.
                if (!checkAndCleanCache(rowCache, board[i][j])) {
                    return false;
                }
                // col check.
                if (!checkAndCleanCache(colCache, board[j][i])) {
                    return false;
                }
                // box check;
                int boxY = i / 3 * 3;
                int boxX = i % 3 * 3;
                boxY += j / 3;
                boxX += j % 3;
                if (!checkAndCleanCache(boxCache, board[boxY][boxX])) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetRouteCache(char[] cache) {
        for (int i = 0; i < 9; i ++) {
            cache[i] = (char) ('1' + i);
        }
    }

    private boolean checkAndCleanCache(char[] cache, char target) {
        int index = target - '1';
        if (index < 0) {
            return true;
        }
        if (index > 8) {
            return true;
        }
        if (cache[index] == target) {
            cache[index] = ' ';
            return true;
        } else {
            return false;
        }
    }
}
