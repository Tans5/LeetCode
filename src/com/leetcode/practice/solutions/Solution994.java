package com.leetcode.practice.solutions;

import java.util.*;

public class Solution994 {

    public int orangesRotting(int[][] grid) {
        Set<List<Integer>> goodPoints = new HashSet<>();
        Set<List<Integer>> badPoints = new HashSet<>();
        for (int r = 0; r < grid.length; r ++) {
            for (int c = 0; c <grid[r].length; c ++) {
                if (grid[r][c] == 1) {
                    goodPoints.add(Arrays.asList(r, c));
                }
                if (grid[r][c] == 2) {
                    badPoints.add(Arrays.asList(r, c));
                }
            }
        }
        if (goodPoints.isEmpty()) {
            return 0;
        }
        int time = 0;
        Set<List<Integer>> gettingBadPoints = new HashSet<>();
        while (!goodPoints.isEmpty()) {
            time ++;
            for (List<Integer> badPoint: badPoints) {
                List<Integer> p1 = Arrays.asList(badPoint.get(0) - 1, badPoint.get(1));
                if (isVailPoint(grid, p1)) {
                    if (goodPoints.remove(p1)) {
                        gettingBadPoints.add(p1);
                    }
                }
                List<Integer> p2 = Arrays.asList(badPoint.get(0) + 1, badPoint.get(1));
                if (isVailPoint(grid, p2)) {
                    if (goodPoints.remove(p2)) {
                        gettingBadPoints.add(p2);
                    }
                }
                List<Integer> p3 = Arrays.asList(badPoint.get(0), badPoint.get(1) - 1);
                if (isVailPoint(grid, p3)) {
                    if (goodPoints.remove(p3)) {
                        gettingBadPoints.add(p3);
                    }
                }
                List<Integer> p4 = Arrays.asList(badPoint.get(0), badPoint.get(1) + 1);
                if (isVailPoint(grid, p4)) {
                    if (goodPoints.remove(p4)) {
                        gettingBadPoints.add(p4);
                    }
                }
            }
            if (gettingBadPoints.isEmpty()) {
                return -1;
            }
            badPoints.addAll(gettingBadPoints);
            gettingBadPoints.clear();
        }
        return time;
    }

    public boolean isVailPoint(int[][] grid, List<Integer> rowAndCol) {
        int row = rowAndCol.get(0);
        int col = rowAndCol.get(1);
        if (row < 0 || row >= grid.length) {
            return false;
        }
        if (col < 0 || col >= grid[row].length) {
            return false;
        }
        return true;
    }
}
