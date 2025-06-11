package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

/**
 * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 *
 * 树中的节点数将在 [0, 104]的范围内。
 * -108 <= Node.val <= 108
 * 所有值 Node.val 是 独一无二 的。
 * -108 <= val <= 108
 * 保证 val 在原始BST中不存在。
 */
public class Solution701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode n = new TreeNode();
            n.val = val;
            return n;
        }
        insert(root, val);
        return root;
    }

    private void insert(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (val < root.val) {
            Integer max = treeMax(root.left);
            if (max == null) {
                TreeNode n = new TreeNode();
                n.val = val;
                root.left = n;
            } else {
                if (max < val) {
                    TreeNode n = new TreeNode();
                    n.val = val;
                    n.left = root.left;
                    root.left = n;
                } else {
                    insert(root.left, val);
                }
            }
        } else {
            Integer min = treeMin(root.right);
            if (min == null) {
                TreeNode n = new TreeNode();
                n.val = val;
                root.right = n;
            } else {
                if (min > val) {
                    TreeNode n = new TreeNode();
                    n.val = val;
                    n.right = root.right;
                    root.right = n;
                } else {
                    insert(root.right, val);
                }
            }
        }
    }

    private Integer treeMax(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return root.val;
        } else {
            return treeMax(root.right);
        }
    }

    private Integer treeMin(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.val;
        } else {
            return treeMin(root.left);
        }
    }
}
