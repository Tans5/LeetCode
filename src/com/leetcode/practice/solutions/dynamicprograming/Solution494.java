package com.leetcode.practice.solutions.dynamicprograming;

/**
 * 给你一个非负整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 */
public class Solution494 {

    public int findTargetSumWays(int[] nums, int target) {
        // positive_sum - negative_sum = target;
        // positive_sum + negative_sum = sum;
        // (positive_sum - negative_sum) + (positive_sum + negative_sum) = target + sum;
        // 2 * positive_sum = target + sum;
        // positive_sum = (target + sum) / 2;
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }
        if (target > 0 && sum < target) {
            return 0;
        }
        if (target < 0 && sum * -1 > target) {
            return 0;
        }
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        int positiveSum = (target + sum) / 2;
        // 和为 i 的数量有多少种
        int[] dp = new int[positiveSum + 1];
        dp[0] = 1;
        for (int num: nums) {
            for (int s = positiveSum; s >= num; s --) {
                dp[s] += dp[s - num];
            }
        }
        return dp[positiveSum];
    }
}
