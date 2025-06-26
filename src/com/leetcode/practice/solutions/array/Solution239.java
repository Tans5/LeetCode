package com.leetcode.practice.solutions.array;

import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *  1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class Solution239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int resultSize = nums.length - k + 1;
        if (resultSize <= 0) {
            return new int[] {};
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[resultSize];
        for (int i = 0; i < nums.length; i ++) {
            int leftIndex = i - k + 1;
            while (leftIndex > 0 && !queue.isEmpty() && queue.peek() < leftIndex) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (leftIndex >= 0) {
                result[leftIndex] = nums[queue.peekFirst()];
            }
        }
        return result;
    }
}
