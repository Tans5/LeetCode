package com.leetcode.practice.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution347 {

    volatile int a = 5;

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hitTimes = new HashMap<>();
        for(Integer num: nums) {
            hitTimes.merge(num, 1, Integer::sum);
        }
        Map.Entry<Integer, Integer>[] keySets = hitTimes.entrySet().toArray(new Map.Entry[hitTimes.size()]);
        Arrays.sort(keySets, (o1, o2) -> o2.getValue() - o1.getValue());
        int[] result = new int[k];
        for (int i = 0; i < k; i ++) {
            result[i] = keySets[i].getKey();
        }
        return result;
    }

}
