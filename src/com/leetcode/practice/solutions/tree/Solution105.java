package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class Solution105 {


    /**
     *          5
     *         / \
     *       3    7
     *      /     / \
     *    1      6   8
     *
     *    preorder: 5 3 1 7 6 8
     *    inorder: 1 3 5 6 7 8
     */
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
        // 中序遍历的 parent index
        Integer inorderParentIndex = inorderNumToIndex.get(node.val);
        if (inorderParentIndex == null) {
            return node;
        }
        // 左子树的大小
        int leftChildLen = inorderParentIndex - inorderStartIndex;
        node.left = buildTree(preorder, inorderNumToIndex, preorderStartIndex + 1, inorderStartIndex, leftChildLen);
        // 右子树的大小
        int rightChildLen = len - leftChildLen - 1;
        node.right = buildTree(preorder, inorderNumToIndex, preorderStartIndex + leftChildLen + 1, inorderParentIndex + 1, rightChildLen);
        return node;
    }
}
