package com.leetcode.practice.solutions;

public class Solution2684 {

    private int maxMove = 0;

    public int maxMoves(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        if (col == 0) {
            return 0;
        }
        maxMove = 0;
        for (int r = 0; r < row; r ++) {
            int v = grid[r][0];
            moveToPosition(v, r - 1, 1, row, col, grid);
            moveToPosition(v, r, 1, row, col, grid);
            moveToPosition(v, r + 1, 1, row, col, grid);
        }
        return maxMove;
    }

    void moveToPosition(int preValue, int toRow, int toCol, int maxRow, int maxCol, int[][] grid) {
        if (toRow >= maxRow || toRow < 0) {
            return;
        }
        if (toCol >= maxCol || toCol < 0) {
            return;
        }
        int value = grid[toRow][toCol];
        if (value > preValue) {
            if (toCol > maxMove) {
                maxMove = toCol;
            }
            moveToPosition(value, toRow - 1, toCol + 1, maxRow, maxCol, grid);
            moveToPosition(value, toRow, toCol + 1, maxRow, maxCol, grid);
            moveToPosition(value, toRow + 1, toCol + 1, maxRow, maxCol, grid);
        }
    }
}
