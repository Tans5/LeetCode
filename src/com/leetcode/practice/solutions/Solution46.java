package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution46 {
    public static List<List<Integer>> permute(int[] nums) {
        int size = nums.length;
        if (size <= 0) {
            return Collections.emptyList();
        }
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        List<List<Integer>> result = new ArrayList<>();
        permute(numsList, new ArrayList<>(), result);
        return result;
    }

    public static void permute(List<Integer> nums, List<Integer> parent, List<List<Integer>> result) {
        if (nums.size() == 1) {
            parent.add(nums.get(0));
            result.add(parent);
        } else {
            for (Integer num: nums) {
                List<Integer> numsCopy = new ArrayList<>(nums);
                List<Integer> parentCopy = new ArrayList<>(parent);
                numsCopy.remove(num);
                parentCopy.add(num);
                permute(numsCopy, parentCopy, result);
            }
        }
    }
}
