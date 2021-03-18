package com.leetcode.practice.solutions;

import java.util.HashMap;
import java.util.Map;

public class Solution137 {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for(Integer n : nums) {
            count.merge(n, 1, Integer::sum);
        }
        int result = -1;
        for (Integer key: count.keySet()) {
            if (count.get(key) <= 1) {
                result = key;
                break;
            }
        }
        return result;
    }
}
