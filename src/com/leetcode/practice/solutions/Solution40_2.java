package com.leetcode.practice.solutions;

import java.util.*;

public class Solution40_2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<int[]> freq = new ArrayList<>();
        List<Integer> route = new ArrayList<>();
        for (int n: candidates) {
            int lastIndex = freq.size() - 1;
            if (freq.isEmpty() || freq.get(lastIndex)[0] != n) {
                freq.add(new int[] {n, 1});
            } else {
                freq.get(lastIndex)[1] ++;
            }
        }
        dfs(freq, route, result, target, 0);
        return result;
    }

    private void dfs(List<int[]> freq, List<Integer> route, List<List<Integer>> result, int target, int index) {
        if (target == 0) {
            if (!route.isEmpty()) {
                result.add(new ArrayList<>(route));
            }
            return;
        }
        int lastIndex = freq.size() - 1;
        if (target < 0 || lastIndex < index || freq.get(index)[0] > target) {
            return;
        }
        dfs(freq, route, result, target, index + 1);

        int[] currentNumAndFreq = freq.get(index);
        int currentNumCount = Math.min(target / currentNumAndFreq[0], currentNumAndFreq[1]);
        int doCount = 0;
        for (int c = 1; c <= currentNumCount; c ++) {
            doCount ++;
            route.add(currentNumAndFreq[0]);
            int nextTarget = target - currentNumAndFreq[0] * c;
            if (nextTarget >= 0) {
                dfs(freq, route, result, nextTarget, index + 1);
            } else {
                break;
            }
        }
        for (int c = 1; c <= doCount; c ++) {
            int routeLastIndex = route.size() - 1;
            route.remove(routeLastIndex);
        }
    }
}
