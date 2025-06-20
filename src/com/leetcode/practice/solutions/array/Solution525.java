package com.leetcode.practice.solutions.array;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [0,1]
 * 输出：2
 * 说明：[0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 *
 *
 * 示例 2：
 *
 * 输入：nums = [0,1,0]
 * 输出：2
 * 说明：[0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
 *
 * 示例 3：
 *
 * 输入：nums = [0,1,1,1,1,1,0,0,0]
 * 输出：6
 * 解释：[1,1,1,0,0,0] 是具有相同数量 0 和 1 的最长连续子数组。
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 */
public class Solution525 {

    // 将 1 设置为 1， 0 设置为 -1，如果 1 和 0 的数量相等，它们的和为 0.
    public int findMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int maxLen = 0;
        int sum = 0;
        // 储存正 sum 的 index.
        short[] prefixPositive = new short[100001];
        // 储存负 sum 的 index.
        short[] prefixNegative = new short[100001];
        for (int i = 0; i < nums.length; i ++) {
            int n;
            if (nums[i] == 0) {
                n = -1;
            } else {
                n = 1;
            }
            sum += n;
            if (sum == 0) {
                if (i + 1 > maxLen) {
                    maxLen = i + 1;
                }
            } else {
                if (sum > 0) {
                    int preIndex = prefixPositive[sum] - 1;
                    if (preIndex >= 0) {
                        int len = i - preIndex;
                        if (len > maxLen) {
                            maxLen = len;
                        }
                    } else {
                        prefixPositive[sum] = (short) (i + 1);
                    }
                } else {
                    int preIndex = prefixNegative[-sum] - 1;
                    if (preIndex >= 0) {
                        int len = i - preIndex;
                        if (len > maxLen) {
                            maxLen = len;
                        }
                    } else {
                        prefixNegative[-sum] = (short) (i + 1);
                    }
                }
            }
        }
        return maxLen;
    }
}
