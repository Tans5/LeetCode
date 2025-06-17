package com.leetcode.practice.solutions.array;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 */
public class Solution11 {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        // 高度低的一边向中间靠拢
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            int width = right - left;
            int area;
            if (leftHeight > rightHeight) {
                right --;
                area = width * rightHeight;
            } else {
                left ++;
                area = width * leftHeight;
            }
            if (area > max) {
                max = area;
            }
        }

        return max;
    }
}
