package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class Solution105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> inorderNumToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++) {
            inorderNumToIndex.put(inorder[i], i);
        }
        return buildTree(preorder, inorderNumToIndex, 0, 0, preorder.length);
    }

    private TreeNode buildTree(int[] preorder, Map<Integer, Integer> inorderNumToIndex, int preorderStartIndex, int inorderStartIndex, int len) {
        if (len <= 0 || (preorderStartIndex + len) > preorder.length) {
            return null;
        }
        TreeNode node = new TreeNode();
        node.val = preorder[preorderStartIndex];
        Integer inorderParentIndex = inorderNumToIndex.get(node.val);
        if (inorderParentIndex == null) {
            return node;
        }
        int leftChildLen = inorderParentIndex - inorderStartIndex;
        node.left = buildTree(preorder, inorderNumToIndex, preorderStartIndex + 1, inorderStartIndex, leftChildLen);
        int rightChildLen = len - leftChildLen - 1;
        node.right = buildTree(preorder, inorderNumToIndex, preorderStartIndex + leftChildLen + 1, inorderParentIndex + 1, rightChildLen);
        return node;
    }
}
