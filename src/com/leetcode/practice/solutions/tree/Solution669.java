package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

/**
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
 *
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 */
public class Solution669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (low > high) {
            return root;
        }
        return trimTreeLowAndHigh(root, low, high);
    }


    private TreeNode trimTreeLowAndHigh(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val >= low && root.val <= high) {
            root.left = trimTreeLowAndHigh(root.left, low, high);
            root.right = trimTreeLowAndHigh(root.right, low, high);
            return root;
        } else if (root.val < low) {
            TreeNode right  = root.right;
            root.right = null;
            return trimTreeLowAndHigh(right, low, high);
        } else {
            TreeNode left = root.left;
            root.left = null;
            return trimTreeLowAndHigh(left, low, high);
        }
    }
}
