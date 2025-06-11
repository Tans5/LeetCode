package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class Solution114 {

    public void flatten(TreeNode root) {
        flattenReturnLast(root);
    }

    private TreeNode flattenReturnLast(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode leftLast = flattenReturnLast(left);
        TreeNode rightLast = flattenReturnLast(right);
        if (leftLast == null) {
            root.right = right;
        } else {
            leftLast.right = right;
        }
        if (rightLast == null) {
            return leftLast;
        } else {
            return rightLast;
        }
    }
}
