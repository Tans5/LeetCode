package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums.length < 1) {
            return result;
        }
        int size = nums.length;
        int resultSize = 1 << size;
        for (int i = 1; i < resultSize; i ++) {
            List<Integer> singleResult = new ArrayList<>();
            for (int j = 0; j < size; j ++) {
                 int a = 1 << j & i;
                 if (a > 0) {
                     singleResult.add(nums[j]);
                 }
            }
            result.add(singleResult);
        }
        return result;
    }
}
