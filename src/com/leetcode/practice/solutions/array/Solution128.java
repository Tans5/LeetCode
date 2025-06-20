package com.leetcode.practice.solutions.array;

import java.util.Arrays;

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

    // 1,0,1,2
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Arrays.sort(nums);
        int longest = 1;
        int baseIndex = 0;
        for (int i = 1; i < nums.length; i ++) {
            int num = nums[i];
            int lastNum = nums[i - 1];
            if (num == lastNum) {
                baseIndex ++;
                continue;
            }
            if (lastNum + 1 == num) {
                if (i - baseIndex + 1 > longest) {
                    longest = i - baseIndex + 1;
                }
                continue;
            }
            baseIndex = i;
        }
        return longest;
    }

}
