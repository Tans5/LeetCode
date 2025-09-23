package com.leetcode.practice.solutions.dynamicprograming;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * nums 的任何子数组的乘积都 保证 是一个 32-位 整数
 */
public class Solution152 {

    public int maxProduct(int[] nums) {
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int len = 1; len <= nums.length; len ++) {
            for (int start = 0; start <= nums.length - len; start ++) {
                int end = start + len - 1;
                int v;
                if (start == end) {
                    v = nums[start];
                } else {
                    // dp[start] 为长度为 len - 1 时，开始的位置为 start 时的乘ji
                    v = dp[start] * nums[end];
                }
                dp[start] = v;
                if (v > max) {
                    max = v;
                }
            }
        }
        return max;
    }
}
