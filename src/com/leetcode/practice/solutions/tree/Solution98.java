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
        if (root == null) {
            return false;
        }
        return treeRange(root) != null;
    }

    /**
     * 返回空表示 当前的树不是二叉搜索树。
     */
    private Integer[] treeRange(TreeNode root) {
        if (root == null) {
            return new Integer[]{null, null};
        }
        int value = root.val;
        Integer[] leftRange = treeRange(root.left);
        if (leftRange == null) {
            return null;
        }
        Integer[] rightRange = treeRange(root.right);
        if (rightRange == null) {
            return null;
        }
        int min;
        int max;
        if (leftRange[0] == null) {
            min = value;
        } else if (leftRange[1] >= value) {
            return null;
        } else {
            min = leftRange[0];
        }
        if (rightRange[1] == null) {
            max = value;
        } else if (rightRange[0] <= value) {
            return null;
        } else {
            max = rightRange[1];
        }
        return new Integer[]{min, max};
    }

}
