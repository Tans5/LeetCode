package com.leetcode.practice.solutions.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 */
public class Solution560 {

    // [1, 2, 3] 3
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Long, Integer> resultTimes = new HashMap<>();
        resultTimes.put(0L, 1);
        long sum = 0L;
        int result = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            int t = resultTimes.getOrDefault(sum - k, 0);
            resultTimes.put(sum, resultTimes.getOrDefault(sum, 0) + 1);
            result += t;
        }
        return result;
    }
}
