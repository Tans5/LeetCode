package com.leetcode.practice.solutions;

import java.util.HashMap;
import java.util.Map;

public class SolutionOffer39 {

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> history = new HashMap<>();
        int midCount = nums.length / 2;
        for (Integer num: nums) {
            history.merge(num, 1, Integer::sum);
            if (history.get(num) > midCount) {
                return num;
            }
        }
        return - 1;
    }
}
