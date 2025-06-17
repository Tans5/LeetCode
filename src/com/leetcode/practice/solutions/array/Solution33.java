package com.leetcode.practice.solutions.array;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 */
public class Solution33 {

    public int search(int[] nums, int target) {
        int startIndex = searchArrayStartIndex(nums, 0, nums.length - 1);
        if (startIndex == -1) {
            return search(nums, 0, nums.length - 1, target);
        } else {
            int ret = search(nums, 0, startIndex - 1, target);
            if (ret != -1) {
                return ret;
            }
            return search(nums, startIndex, nums.length - 1, target);
        }
    }


    private int searchArrayStartIndex(int[] nums, int start, int end) {
        if (start >= end) {
            return -1;
        }
        if (nums[start] > nums[end]) {
            if (end - start == 1) {
                return end;
            } else {
                int mid = (start + end) / 2;
                if (mid + 1 < nums.length && nums[mid + 1] < nums[mid]) {
                    return mid + 1;
                }
                int ret = searchArrayStartIndex(nums, start, mid);
                if (ret != -1) {
                    return ret;
                }
                return searchArrayStartIndex(nums, mid + 1, end);
            }
        } else {
            return -1;
        }
    }

    private int search(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int n = nums[mid];
        if (n == target) {
            return mid;
        }
        if (n > target) {
            return search(nums, start, mid - 1, target);
        }
        return search(nums, mid + 1, end, target);
    }
}
