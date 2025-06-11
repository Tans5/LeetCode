package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 */
public class Solution106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        Map<Integer, Integer> inorderNumToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++) {
            inorderNumToIndex.put(inorder[i], i);
        }
        return buildTree(inorderNumToIndex, postorder, 0, 0, inorder.length);
    }

    private TreeNode buildTree(Map<Integer, Integer> inorderNumToIndex, int[] postorder, int inorderStartIndex, int postorderStartIndex, int len) {
        if (len <= 0 || postorderStartIndex + len > postorder.length) {
            return null;
        }
        int postorderLastIndex = postorderStartIndex + len - 1;
        TreeNode parent = new TreeNode();
        parent.val = postorder[postorderLastIndex];
        Integer inorderParentEndIndex = inorderNumToIndex.get(parent.val);
        if (inorderParentEndIndex == null) {
            return null;
        }
        int leftChildLen = inorderParentEndIndex - inorderStartIndex;
        parent.left = buildTree(inorderNumToIndex, postorder, inorderStartIndex, postorderStartIndex, leftChildLen);
        int rightChildLen = len - leftChildLen - 1;
        parent.right = buildTree(inorderNumToIndex, postorder, inorderStartIndex + leftChildLen + 1, postorderStartIndex + leftChildLen, rightChildLen);
        return parent;
    }
}
