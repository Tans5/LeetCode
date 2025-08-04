package com.leetcode.practice.solutions.graph;

/**
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 *
 *
 * 提示：
 *
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */
public class Solution547 {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i ++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i ++) {
            for (int j = i + 1; j < n; j ++) {
                if (isConnected[i][j] == 1) {
                    union(i, j, parent, rank);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i ++) {
            if (parent[i] == i) {
                count ++;
            }
        }
        return count;
    }

    private void union(int a, int b, int[] parent, int[] rank) {
        int aParent = findAndCompress(a, parent);
        int bParent = findAndCompress(b, parent);
        if (aParent == bParent) {
            return;
        }
        if (rank[aParent] > rank[bParent]) {
            parent[bParent] = aParent;
        } else if (rank[aParent] < rank[bParent]) {
            parent[aParent] = bParent;
        } else {
            parent[bParent] = aParent;
            rank[aParent] ++;
        }
    }

    private int findAndCompress(int a, int[] parent) {
        while (parent[a] != a) {
            parent[a] = parent[parent[a]];
            a = parent[a];
        }
        return parent[a];
    }
}
