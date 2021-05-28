package com.leetcode.practice.solutions;

import java.util.*;

public class Solution448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int lastNum = 0;
        for(int num: nums) {
            for (int i = lastNum + 1; i < num; i ++) {
                result.add(i);
            }
            lastNum = num;
        }
        for (int i = lastNum + 1; i <= size; i ++) {
            result.add(i);
        }
        return result;
    }

}
