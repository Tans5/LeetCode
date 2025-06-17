package com.leetcode.practice.solutions.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class Solution128 {

    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Arrays.sort(nums);
        return longest(nums, 0, nums.length - 1);
    }

    private int longest(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }

        int longest = 1;
        int baseNum = nums[start];
        int baseIndex = start;
        int lastNum = baseNum;
        int i = start + 1;
        for (; i <= end; i ++) {
            int n = nums[i];
            if (n == lastNum) {
                baseIndex ++;
                continue;
            }
            if (n - baseNum == i - baseIndex) {
                lastNum = n;
                longest ++;
            } else {
                break;
            }
        }
        return Math.max(longest, longest(nums, i, end));
    }

}
