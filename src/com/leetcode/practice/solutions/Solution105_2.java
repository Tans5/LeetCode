package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution105_2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> inorderValueToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++) {
            inorderValueToIndex.put(inorder[i], i);
        }
        return buildTree(preorder, 0, 0, preorder.length, inorderValueToIndex);
    }

    private TreeNode buildTree(
            int[] preorder,
            int preorderStartIndex,
            int inorderStartIndex,
            int count,
            Map<Integer, Integer> inorderValueToIndex
    ) {
        if (count <= 0) {
            return null;
        }
        int parentNodeNum = preorder[preorderStartIndex];
        TreeNode node = new TreeNode(parentNodeNum);
        int midIndex = inorderValueToIndex.get(parentNodeNum);

        // leftTree
        int leftTreeCount = getLeftTreeCount(midIndex, inorderStartIndex);
        int leftTreePreorderStartIndex = preorderStartIndex + 1;
        int leftTreeInorderStartIndex = inorderStartIndex;
        node.left = buildTree(preorder, leftTreePreorderStartIndex, leftTreeInorderStartIndex, leftTreeCount, inorderValueToIndex);

        // rightTree
        int rightTreeCount = getRightTreeCount(midIndex, inorderStartIndex + count - 1);
        int rightTreePreorderStartIndex = leftTreeCount + leftTreePreorderStartIndex;
        int rightInorderStartIndex = midIndex + 1;
        node.right = buildTree(preorder, rightTreePreorderStartIndex, rightInorderStartIndex, rightTreeCount, inorderValueToIndex);
        return node;
    }

    private int getLeftTreeCount(int midIndex, int startIndex) {
        return midIndex - startIndex;
    }

    private int getRightTreeCount(int midIndex, int endIndex) {
        return endIndex - midIndex;
    }
}
