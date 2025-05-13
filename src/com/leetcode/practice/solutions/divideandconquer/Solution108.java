package com.leetcode.practice.solutions.divideandconquer;

import com.leetcode.practice.solutions.others.TreeNode;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
 */
public class Solution108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums, 0, nums.length - 1);
    }

    private TreeNode createTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode n = new TreeNode();
        if (start == end) {
            n.val = nums[start];
        } else {
            int mid = (start + end) / 2;
            n.val = nums[mid];
            n.left = createTree(nums, start, mid - 1);
            n.right = createTree(nums, mid + 1, end);
        }
        return n;
    }
}
