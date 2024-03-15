package com.leetcode.practice.solutions;

import java.util.*;

public class Solution1976 {
    private long minCost = Long.MAX_VALUE;
    private long minCostTimes = 0;

    public int countPaths(int n, int[][] roads) {
        minCost = Long.MAX_VALUE;
        minCostTimes = 0;
        if (n <= 0) {
            return 0;
        }
        HashMap<Integer, List<int[]>> roadsMap = new HashMap<>();
        for (int[] r: roads) {
            int start = r[0];
            int end = r[1];
            int cost = r[2];
            List<int[]> sl = roadsMap.get(start);
            if (sl == null) {
                sl = new ArrayList<>();
                roadsMap.put(start, sl);
            }
            sl.add(new int[]{ end, cost});
            List<int[]> el = roadsMap.get(end);
            if (el == null) {
                el = new ArrayList<>();
                roadsMap.put(end, el);
            }
            el.add(new int[] {start, cost});
        }
        findRoute(roadsMap,0L, 0, n - 1);
        if (minCost == Long.MAX_VALUE) {
            return 0;
        } else {
            return (int) (minCostTimes % 1000000007);
        }
    }

    void findRoute(Map<Integer, List<int[]>> roadsMap, long cost, int start, int end) {
        if (start == end) {
            if (cost == minCost) {
                minCostTimes ++;
            }
            if (cost < minCost) {
                minCost = cost;
                minCostTimes = 1;
            }
            return;
        }
        List<int[]> nextChoice = roadsMap.remove(start);
        if (nextChoice == null) {
            return;
        }
        for (int[] r: nextChoice) {
            long newCost = cost + r[1];
            if (newCost <= minCost) {
                findRoute(roadsMap, newCost, r[0], end);
            }
        }
        roadsMap.put(start, nextChoice);
    }
}
