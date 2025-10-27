package com.leetcode.practice.solutions.array;

/**
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 *
 * 你必须尽可能减少整个操作步骤。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * 输出：false
 */
public class Solution81 {

    // [1,0,1,1,1], 0
    public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int midNum = nums[mid];
            if (midNum == target) {
                return true;
            }
            int loNum = nums[lo];
            int hiNum = nums[hi];
            if (loNum == midNum) {
                lo ++;
                continue;
            }
            if (hiNum == midNum) {
                hi --;
                continue;
            }
            // loNum != midNum, hiNum != midNum


            if (loNum < midNum) { // [lo, mid) sorted and range in [loNum, midNum)
                if (target >= loNum && target < midNum) { // target in [lo, mid)
                    hi = mid - 1;
                } else { // target in (mid, hi]
                    lo = mid + 1;
                }
            } else { // (mid, hi] sorted and range in (midNum, hiNum]
                if (target > midNum && target <= hiNum) { // target in (mid, hi]
                    lo = mid + 1;
                } else { // target in [lo, mid)
                    hi = mid - 1;
                }
            }
        }
        return false;
    }
}
