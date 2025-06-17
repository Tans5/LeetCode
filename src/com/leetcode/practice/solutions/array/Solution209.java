package com.leetcode.practice.solutions.array;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class Solution209 {

    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right ++) {
            sum += nums[right];
            while (sum >= target) {
                int len = right - left + 1;
                if (len < minLen) {
                    minLen = len;
                }
                sum -= nums[left ++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        // i 到 j 的和
        int[][] dp = new int[nums.length][nums.length];
        for (int len = 1; len <= nums.length; len ++) {
            for (int startIndex = 0; startIndex <= nums.length - len; startIndex ++) {
                int endIndex = startIndex + len - 1;
                int s;
                if (startIndex == endIndex) {
                    s = nums[startIndex];
                } else {
                    s = dp[startIndex + 1][endIndex] + nums[startIndex];
                }
                dp[startIndex][endIndex] = s;
                if (s >= target && len < minLen) {
                    minLen = len;
                }
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLen;
        }
    }
}
