package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution320 {

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i: nums1) {
            Integer hitTimes = resultMap.get(i);
            if (hitTimes == null) {
                resultMap.put(i, 1);
            } else {
                resultMap.put(i, hitTimes + 1);
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for (int i: nums2) {
            if (resultMap.containsKey(i)) {
                Integer hitTimes = resultMap.get(i);
                if (hitTimes > 0) {
                    resultList.add(i);
                    resultMap.put(i, hitTimes - 1);
                }
            }
        }
        int size = resultList.size();
        int[] result = new int[size];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
