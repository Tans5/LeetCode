package com.leetcode.practice.solutions.array;

/**
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 *
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,4,2,1]
 * 输出：1
 *
 * 提示：
 *
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 */
public class Solution287 {


    public int findDuplicate(int[] nums) {
        int start = 1;
        int end = nums.length;
        while (start < end) {
            int mid = (end + start) / 2;
            int count = 0;
            for (int n: nums) {
                if (n <= mid) {
                    count ++;
                }
            }
            if (count > mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
