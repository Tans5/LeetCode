package com.leetcode.practice.interview;


/**
 * 数组 nums 已经升序排列，输入 n，返回 n 在 nums 中的数量
 *
 * 例：
 * nums=[1,2,2,2,3,4,5], n=2, count=3
 */
public class Bytedance3 {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 2, 2, 3, 5};
        int n = 2;
        System.out.println(countN(nums, n));
    }

    public static int countN(int[] nums, int n) {
        int left = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid == 0 && nums[mid] == n) {
                left = mid;
                break;
            }
            if (nums[mid] == n && nums[mid - 1] != n) {
                left = mid;
                break;
            }
            if (nums[mid] == n) {
                end = mid - 1;
            } else if (nums[mid] > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (left == -1) {
            return 0;
        }

        int right = -1;
        start = left;
        end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == n && mid == nums.length - 1) {
                right = mid;
                break;
            }
            if (nums[mid] == n && nums[mid + 1] != n) {
                right = mid;
                break;
            }
            if (nums[mid] == n) {
                start = mid + 1;
            } else if (nums[mid] > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return right - left + 1;
    }
}
