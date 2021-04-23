package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution594 {

    public static int findLHS(int[] nums) {
        int maxLen = 0;
        int[] sortedNums = new int[nums.length];
        System.arraycopy(nums, 0, sortedNums, 0, sortedNums.length);
        Arrays.sort(sortedNums);
        List<Integer[]> pairs = new ArrayList<>();
        for (int i = 0; i < sortedNums.length - 1; i ++) {
            while (i < sortedNums.length - 1 && sortedNums[i] + 1 != sortedNums[i + 1]) {
                i ++;
            }
            if (i != sortedNums.length - 1) {
                Integer[] pair = new Integer[2];
                pair[0] = sortedNums[i];
                pair[1] = sortedNums[i + 1];
                pairs.add(pair);
            }
        }

        for (Integer[] pair: pairs) {
            int start = pair[0];
            int end = pair[1];
            int len = 0;
            for (int num : nums) {
                if (num == start || num == end) {
                    len++;
                }
            }
            if (len > maxLen) {
                maxLen = len;
            }
        }
        return maxLen;
    }
}
