package com.leetcode.practice.solutions;

public class Solution289 {

    public void gameOfLife(int[][] board) {
        int width = board[0].length;
        int height = board.length;
        int[][] oldBoard = new int[height][width];
        for (int i = 0; i < height; i ++) {
            System.arraycopy(board[i], 0, oldBoard[i], 0, width);
        }
        for (int y = 0; y < height; y ++) {
            for (int x = 0; x < width; x ++) {
                checkLife(x, y, oldBoard, board, width, height);
            }
        }
    }

    void checkLife(int x, int y, int[][] oldBoard, int[][] newBoard, int width, int height) {
        boolean meIsAlive = oldBoard[y][x] == 1;
        int aroundLiveCount = 0;
        if (x - 1 >= 0 && y - 1 >= 0 && oldBoard[y - 1][x - 1] == 1) {
            aroundLiveCount ++;
        }
        if (y - 1 >= 0 && oldBoard[y - 1][x] == 1) {
            aroundLiveCount ++;
        }
        if (x + 1 < width && y - 1 >= 0 && oldBoard[y - 1][x + 1] == 1) {
            aroundLiveCount ++;
        }
        if (x + 1 < width && oldBoard[y][x + 1] == 1) {
            aroundLiveCount ++;
        }
        if (x + 1 < width && y + 1 < height && oldBoard[y + 1][x + 1] == 1) {
            aroundLiveCount ++;
        }
        if (y + 1 < height && oldBoard[y + 1][x] == 1) {
            aroundLiveCount ++;
        }
        if (x - 1 >= 0 && y + 1 < height && oldBoard[y + 1][x - 1] == 1) {
            aroundLiveCount ++;
        }
        if (x - 1 >= 0 && oldBoard[y][x - 1] == 1) {
            aroundLiveCount ++;
        }

        if (meIsAlive) {
            if (aroundLiveCount == 3 || aroundLiveCount == 2) {
                newBoard[y][x] = 1;
            } else {
                newBoard[y][x] = 0;
            }
        } else {
            if (aroundLiveCount == 3) {
                newBoard[y][x] = 1;
            } else {
                newBoard[y][x] = 0;
            }
        }
    }
}
