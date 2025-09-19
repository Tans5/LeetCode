package com.leetcode.practice.solutions.array;

/**
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 */
public class Solution31 {

    public void nextPermutation(int[] nums) {
        // 反向遍历
        for (int i = nums.length - 2; i >= 0; i --) {
            Integer toSwapIndex = null;
            // 从 i + 1 开始找，找到大于 i 的值中最小的
            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[i] < nums[j]) {
                    if (toSwapIndex == null) {
                        toSwapIndex = j;
                    } else {
                        if (nums[j] < nums[toSwapIndex]) {
                            toSwapIndex = j;
                        }
                    }
                }
            }
            if (toSwapIndex != null) {
                // 交换 i 和上面找到的值
                swap(nums, i, toSwapIndex);
                // 排序 i + 1 后续的值
                sort(nums, i + 1, nums.length - 1);
                return;
            }
        }
        for (int i = 0; i < nums.length / 2; i ++) {
            swap(nums, i, nums.length - i - 1);
        }
    }


    private void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int baseNum = nums[start];
        while (i < j) {
            while (i < j && nums[j] >= baseNum) {
                j --;
            }
            while (i < j && nums[i] <= baseNum) {
                i ++;
            }
            swap(nums, i, j);
        }
        swap(nums, start, i);
        sort(nums, start, i - 1);
        sort(nums, i + 1, end);
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
