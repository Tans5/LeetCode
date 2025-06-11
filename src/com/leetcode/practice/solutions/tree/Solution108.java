package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
 */
public class Solution108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    private TreeNode buildTree(int[] nums, int startIndex, int len) {
        if (len <= 0 || startIndex + len > nums.length) {
            return null;
        }
        int midIndex = (startIndex + startIndex + len) / 2;
        TreeNode parent = new TreeNode();
        parent.val = nums[midIndex];
        parent.left = buildTree(nums, startIndex, midIndex - startIndex);
        parent.right = buildTree(nums, midIndex + 1, len - 1 - midIndex + startIndex);
        return parent;
    }
}
