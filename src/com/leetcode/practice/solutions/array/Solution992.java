package com.leetcode.practice.solutions.array;

import java.util.Arrays;

/**
 * 给定一个正整数数组 nums和一个整数 k，返回 nums 中 「好子数组」 的数目。
 *
 * 如果 nums 的某个子数组中不同整数的个数恰好为 k，则称 nums 的这个连续、不一定不同的子数组为 「好子数组 」。
 *
 * 例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。
 * 子数组 是数组的 连续 部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,1,2,3], k = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * 示例 2：
 *
 * 输入：nums = [1,2,1,3,4], k = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i], k <= nums.length
 */
public class Solution992 {

    /**
     * 恰好 k 种 = 最多 k 种 - 最多 k - 1 种
     */
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    /**
     * 最多 k 种不同的数量
     */
    private int atMost(int[] nums, int k) {
        if (k <= 0) {
            return 0;
        }
        int[] numsCount = new int[nums.length + 1];
        int types = 0;
        int start = 0;
        int end = 0;
        int res = 0;
        while (end < nums.length) {
            int en = nums[end];
            numsCount[en] ++;
            if (numsCount[en] == 1) {
                types ++;
            }
            while (start <= end && types > k) {
                int sn = nums[start];
                numsCount[sn] --;
                if (numsCount[sn] == 0) {
                    types --;
                }
                start ++;
            }
            // start 到 end 中，以 end 结尾的数组的子数组的数量.
            res += (end - start + 1);
            end ++;
        }
        return res;
    }

    public int subarraysWithKDistinct2(int[] nums, int k) {
        int[] numsCount = new int[nums.length + 1];
        int numsType = 0;
        int res = 0;
        int end = 0;
        while (end < nums.length) {
            int en = nums[end];
            numsCount[en] ++;
            if (numsCount[en] == 1) {
                numsType ++;
            }
            if (numsType == k) {
                res ++;
            }
            if (numsType >= k) {
                int start = 0;
                int[] leftNumsCount = Arrays.copyOf(numsCount, numsCount.length);
                int leftNumsType = numsType;
                while (leftNumsType >= k) {
                    int sn = nums[start];
                    leftNumsCount[sn] --;
                    start ++;
                    if (leftNumsCount[sn] == 0) {
                        leftNumsType --;
                    }
                    if (leftNumsType == k) {
                        res ++;
                    }
                }
            }
            end ++;
        }

        return res;
    }
}
