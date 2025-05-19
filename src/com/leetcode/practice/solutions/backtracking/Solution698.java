package com.leetcode.practice.solutions.backtracking;


import java.util.Arrays;

/**
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 *
 *
 * 示例 1：
 *
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 */
public class Solution698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k) {
            return false;
        }
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }
        if (sum % k != 0) {
            return false;
        }
        int targetSum = sum / k;
        if (targetSum == 0) {
            return false;
        }
        Arrays.sort(nums);
        if (nums[nums.length - 1] > targetSum) {
            return false;
        }
        int i = nums.length - 1;
        while (i >= 0 && nums[i] == targetSum) {
            k --;
            i --;
        }

        int[] buckets = new int[k];
        return backtracking(nums, buckets, i, targetSum);
    }

    boolean backtracking(int[] nums, int[] buckets, int index, int targetSum) {
        if (index < 0) {
            return true;
        }
        int targetNum = nums[index];
        for (int i = 0; i < buckets.length; i ++) {
            if (buckets[i] + targetNum <= targetSum) {
                buckets[i] += targetNum;
                if (backtracking(nums, buckets, index - 1, targetSum)) {
                    return true;
                }
                buckets[i] -= targetNum;
            }
        }
        return false;
    }

}
