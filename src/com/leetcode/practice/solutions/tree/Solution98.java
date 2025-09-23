package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Solution98 {

    public boolean isValidBST(TreeNode root) {
        return treeRange(root) != null;
    }

    /**
     * 返回空表示 当前的树不是二叉搜索树。
     */
    private Integer[] treeRange(TreeNode root) {
        if (root == null) {
            return null;
        }
        int value = root.val;
        int min;
        int max;
        if (root.left != null) {
            Integer[] range = treeRange(root.left);
            if (range == null) {
                return null;
            }
            if (range[1] >= value) {
                return null;
            }
            min = range[0];
        } else {
            min = value;
        }

        if (root.right != null) {
            Integer[] range = treeRange(root.right);
            if (range == null) {
                return null;
            }
            if (range[0] <= value) {
                return null;
            }
            max = range[1];
        } else {
            max = value;
        }
        if (min > max) {
            return null;
        } else {
            return new Integer[] {min, max};
        }
    }

}
