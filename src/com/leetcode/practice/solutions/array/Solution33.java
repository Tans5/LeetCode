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

    public static void main(String[] args) {
        int[] nums = new int[] {8,9,2,3,4};
        int target = 9;
        Solution33 s = new Solution33();
        System.out.println(s.search(nums, target));
    }

    public int search(int[] nums, int target) {
        // 先找到真实的数组开始的 index
        int startIndex = searchArrayStartIndex(nums);
        if (startIndex == -1) { // 未反转，直接查询
            return search(nums, 0, nums.length - 1, target);
        } else {
            // 先二分查询左边
            int ret = search(nums, 0, startIndex - 1, target);
            if (ret != -1) {
                return ret;
            }
            // 再二分查询右边
            return search(nums, startIndex, nums.length - 1, target);
        }
    }

    private int searchArrayStartIndex(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high - 1) {
            int mid = (high + low) / 2;
            int midNum = nums[mid];
            int lowNum = nums[low];
            if (lowNum > midNum) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if (nums[low] > nums[high]) {
            return high;
        } else {
            return -1;
        }
    }

    private int search(int[] nums, int start, int end, int target) {
        int low = start;
        int high = end;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // 4,5,6,7,0,1,2
    public int search2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midNum = nums[mid];
            if (midNum == target) {
                return mid;
            }
            int lowNum = nums[low];
            int highNum = nums[high];
            if (lowNum <= midNum) { // [low, mid] sorted
                if (target < midNum && target >= lowNum) { // target in [low, mid)
                    high = mid - 1;
                } else { // target in (mid, high]
                    low = mid + 1;
                }
            } else { // (mid, high] sorted
                if (target > midNum && target <= highNum) { // target in (mid, high]
                    low = mid + 1;
                } else { // target in [low, mid)
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
