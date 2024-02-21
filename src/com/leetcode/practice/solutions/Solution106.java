package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0 || postorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> inorderValueToIndex = new HashMap<>();
        int[] revertPostorder = new int[postorder.length];
        for (int i = 0; i < postorder.length; i ++) {
            inorderValueToIndex.put(inorder[i], i);
            revertPostorder[postorder.length - 1 - i] = postorder[i];
        }
        return buildTree(inorderValueToIndex, revertPostorder, 0, 0, postorder.length);
    }

    private TreeNode buildTree(
            Map<Integer, Integer> inorderValueToIndex,
            int[] revertPostorder,
            int inorderStartIndex,
            int revertPostorderIndex,
            int count) {
        if (count <= 0) {
            return null;
        }
        int parentNum = revertPostorder[revertPostorderIndex];
        TreeNode result = new TreeNode(parentNum);
        int inorderMidIndex = inorderValueToIndex.get(parentNum);

        int leftTreeCount = inorderMidIndex - inorderStartIndex;
        int rightTreeCount = count - 1 - leftTreeCount;
        int leftInorderStartIndex = inorderStartIndex;
        int rightInorderStartIndex = inorderMidIndex + 1;
        int rightRevertPostorderIndex = revertPostorderIndex + 1;
        int leftRevertPostorderIndex = rightRevertPostorderIndex + rightTreeCount;
        result.left = buildTree(inorderValueToIndex, revertPostorder, leftInorderStartIndex, leftRevertPostorderIndex, leftTreeCount);
        result.right = buildTree(inorderValueToIndex, revertPostorder, rightInorderStartIndex, rightRevertPostorderIndex, rightTreeCount);
        return result;
    }
}
