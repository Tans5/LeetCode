package com.leetcode.practice.solutions;

import java.util.Arrays;

public class Solution169 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}
