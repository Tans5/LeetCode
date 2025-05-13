package com.leetcode.practice.solutions.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] ignorePoints = new boolean[n][n];
        backtracking(new ArrayList<>(), n, result, ignorePoints, 0);
        return result;
    }

    private void backtracking(
            List<List<Integer>> state,
            int n,
            List<List<String>> result,
            boolean[][] ignorePoints,
            int offset
    ) {
        if (state.size() == n) {
            List<byte[]> map = new ArrayList<>();
            for (int i = 0; i < n; i ++) {
                map.add(new byte[n]);
                Arrays.fill(map.get(i), (byte) '.');
            }
            for (List<Integer> point: state) {
                map.get(point.get(0))[point.get(1)] = 'Q';
            }
            List<String> sMap = new ArrayList<>();
            for (int i = 0; i < map.size(); i ++) {
                String s = new String(map.get(i));
                sMap.add(s);
            }
            result.add(sMap);
            return;
        }
        if (offset >= (n * n)) {
            return;
        }
        List<Integer> point = new ArrayList<>(2);
        point.add(0);
        point.add(0);
        for (int t = offset; t < n * n; t ++) {
            int x = t / n;
            int y = t % n;
            point.set(0, x);
            point.set(1, y);
            if (!ignorePoints[x][y]) {
                state.add(new ArrayList<>(point));
                 List<Integer> addPoints = calculateIgnorePoints(x, y, n, ignorePoints);
                backtracking(state, n, result, ignorePoints, t + 1);
                state.remove(state.size() - 1);
                for (int i: addPoints) {
                    x = i / n;
                    y = i % n;
                    ignorePoints[x][y] = false;
                }
            }
        }
    }

    private List<Integer> calculateIgnorePoints(
            int x, int y,
            int n,
            boolean[][] ignorePoints) {
        List<Integer> result = new ArrayList<>();

        // 横竖
        for (int i = 0; i < n; i ++) {
            int p1 = i * n + y;
            if (!ignorePoints[i][y]) {
                ignorePoints[i][y] = true;
                result.add(p1);
            }

            int p2 = x * n + i;
            if (!ignorePoints[x][i]) {
                ignorePoints[x][i] = true;
                result.add(p2);
            }
        }

        // 左上角到右下角
        int ltStartX, ltStartY;
        if (x > y) {
            ltStartX = x - y;
            ltStartY = 0;
        } else {
            ltStartX = 0;
            ltStartY = y - x;
        }
        do {
            int p = ltStartX * n + ltStartY;
            if (!ignorePoints[ltStartX][ltStartY]) {
                ignorePoints[ltStartX][ltStartY] = true;
                result.add(p);
            }
            ltStartX ++;
            ltStartY ++;
        } while(ltStartX < n && ltStartY < n);

        // 右上角到左下角
        int rtStartX, rtStartY;

        if (x > (n - y - 1)) {
            rtStartX = x - (n - y - 1);
            rtStartY = n - 1;
        } else {
            rtStartX = 0;
            rtStartY = y + x;
        }
        do {
            int p = rtStartX * n + rtStartY;
            if (!ignorePoints[rtStartX][rtStartY]) {
                ignorePoints[rtStartX][rtStartY] = true;
                result.add(p);
            }
            rtStartX ++;
            rtStartY --;
        } while (rtStartY >= 0 && rtStartX < n);

        return result;
    }

}
