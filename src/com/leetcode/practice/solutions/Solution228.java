package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add("" + nums[0]);
            return result;
        }
        int rangeStart = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            int preValue = nums[i - 1];
            int value = nums[i];
            if (preValue + 1 != value) {
                if (preValue != rangeStart) {
                    result.add(rangeStart + "->" + preValue);
                } else {
                    result.add("" + preValue);
                }
                rangeStart = value;
            }
            if (i == nums.length - 1) {
                if (value != rangeStart) {
                    result.add(rangeStart + "->" + value);
                } else {
                    result.add("" + value);
                }
            }

        }
        return result;
    }

}
