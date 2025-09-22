package com.leetcode.practice.solutions.backtracking;

/**
 * 给你一个非负整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 */
public class Solution494 {

    public int findTargetSumWays(int[] nums, int target) {
        return backtracking(nums, 0, target, 0);
    }

    int backtracking(int[] nums, int startIndex, int target, int sum) {
        if (startIndex >= nums.length) {
            return sum == target ? 1 : 0;
        }
        int count = 0;
        int num = nums[startIndex];
        // -
        count += backtracking(nums, startIndex + 1, target, sum - num);
        // +
        count += backtracking(nums, startIndex + 1, target, sum + num);
        return count;
    }
}
