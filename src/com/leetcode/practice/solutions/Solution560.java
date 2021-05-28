package com.leetcode.practice.solutions;

public class Solution560 {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sumStart = 0;
        int sum = 0;
        for (int len = 1; len <= nums.length; len ++) {
            sumStart += nums[len - 1];
            sum = sumStart;
            if (sum == k) {
                count ++;
            }
            for (int i = 1; i < nums.length - len; i ++) {
                sum -= nums[i - 1];
                sum += nums[i + len - 1];
                if (sum == k) {
                    count ++;
                }
            }
        }
        return count;
    }

}
