package com.leetcode.practice.solutions.array;


/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 */
public class Solution4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        if (nums.length == 0) {
            return 0;
        }
        int targetIndex = nums.length / 2;
        int index = 0;
        int n1Index = 0;
        int n2Index = 0;
        while (n1Index < nums1.length && n2Index < nums2.length) {
            int n1 = nums1[n1Index];
            int n2 = nums2[n2Index];
            if (n1 < n2) {
                nums[index ++] = n1;
                n1Index ++;
            } else {
                nums[index ++] = n2;
                n2Index ++;
            }
            if (index - 1 == targetIndex) {
                if (nums.length % 2 == 1) {
                    return nums[targetIndex];
                } else {
                    return (double) (nums[targetIndex] + nums[targetIndex - 1]) / 2;
                }
            }
        }
        if (n1Index < nums1.length) {
            System.arraycopy(nums1, n1Index, nums, index, nums1.length - n1Index);
        } else {
            System.arraycopy(nums2, n2Index, nums, index, nums2.length - n2Index);
        }
        if (nums.length % 2 == 1) {
            return nums[targetIndex];
        } else {
            return (double) (nums[targetIndex] + nums[targetIndex - 1]) / 2;
        }
    }
}
