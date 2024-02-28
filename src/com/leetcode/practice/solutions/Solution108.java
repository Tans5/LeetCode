package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {

        return buildTree(null, nums, 0, nums.length);
    }

    public TreeNode buildTree(TreeNode parentNode, int[] nums, int startIndex, int size) {
        if (size <= 0) {
            return null;
        }
        int midIndex = (startIndex + startIndex + size) / 2;
        int midValue = nums[midIndex];
        TreeNode node = new TreeNode(midValue);
        if (parentNode != null) {
            if (midValue <= parentNode.val) {
                parentNode.left = node;
            } else {
                parentNode.right = node;
            }
        }
        int leftStartIndex = startIndex;
        int leftSize = midIndex - startIndex;
        buildTree(node, nums, leftStartIndex, leftSize);

        int rightStartIndex = midIndex + 1;
        int rightSize = startIndex + size - 1 - midIndex;
        buildTree(node, nums, rightStartIndex, rightSize);
        return node;
    }
}
