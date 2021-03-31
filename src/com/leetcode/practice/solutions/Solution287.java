package com.leetcode.practice.solutions;

import java.util.HashMap;
import java.util.Map;

public class Solution287 {

    public int findDuplicate(int[] nums) {
        Map<Integer, Boolean> scanHistory = new HashMap<>();
        for (Integer num: nums) {
            if (scanHistory.get(num) == null) {
                scanHistory.put(num, true);
            } else {
                return num;
            }
        }
        return - 1;
    }

}
