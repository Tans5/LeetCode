package com.leetcode.practice.solutions.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
 *
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
 *
 *
 * 提示：
 *
 * 1 <= n <= 100
 * 0 <= flights.length <= (n * (n - 1) / 2)
 * flights[i].length == 3
 * 0 <= fromi, toi < n
 * fromi != toi
 * 1 <= pricei <= 104
 * 航班没有重复，且不存在自环
 * 0 <= src, dst, k < n
 * src != dst
 */
public class Solution787 {


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 上一次转机花费最小
        int[] pre = new int[n];
        Arrays.fill(pre, Integer.MAX_VALUE);
        pre[src] = 0;
        int ret = Integer.MAX_VALUE;
        int[] next = new int[n];
        System.arraycopy(pre, 0, next, 0, n);
        for (int i = 0; i < k + 1; i ++) {
            boolean isUpdate = false;
            for (int[] f: flights) {
                int s = f[0];
                int t = f[1];
                int c = f[2];
                if (pre[s] != Integer.MAX_VALUE && pre[s] + c < next[t]) {
                    next[t] = pre[s] + c;
                    isUpdate = true;
                }
            }
            if (!isUpdate) {
                break;
            }
            System.arraycopy(next, 0, pre, 0, n);
            if (pre[dst] < ret) {
                ret = pre[dst];
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }

    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] f: flights) {
            List<int[]> to = graph.computeIfAbsent(f[0], (key) -> { return new ArrayList<>(); });
            to.add(new int[] {f[1], f[2]});
        }
        boolean[] visited = new boolean[n];
        visited[src] = true;
        return routeTo(src, 0, dst, k, visited, -1, graph);
    }

    private int routeTo(int pre, int preCost, int dst, int maxTimes, boolean[] visited, int times, Map<Integer, List<int[]>> graph) {
        if (pre == dst) {
            if (times <= maxTimes) {
                return preCost;
            }
            return -1;
        }
        if (times > maxTimes) {
            return -1;
        }

        int minCost = Integer.MAX_VALUE;
        List<int[]> next = graph.get(pre);
        if (next != null) {
            for (int[] n: next) {
                int nextDst = n[0];
                int nextDstCost = n[1];
                if (!visited[nextDst]) {
                    visited[nextDst] = true;
                    int c = routeTo(nextDst, preCost + nextDstCost, dst, maxTimes, visited, times + 1, graph);
                    if (c != -1 && c < minCost) {
                        minCost = c;
                    }
                    visited[nextDst] = false;
                }
            }
        }
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}
