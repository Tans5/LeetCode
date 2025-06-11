package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *
 * 提示:
 *
 * 节点数的范围 [0, 104].
 * -105 <= Node.val <= 105
 * 节点值唯一
 * root 是合法的二叉搜索树
 * -105 <= key <= 105
 *
 *
 * 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。
 */
public class Solution450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode[] t = findTargetNode(root, key);
        if (t != null) {
            TreeNode toDeleteNode = t[0];
            TreeNode toDeleteNodeParent = t[1];
            if (toDeleteNodeParent == null) {
                // 删除的节点是 root 节点
                if (root.left != null && root.right != null) {
                    TreeNode result = root.left;
                    findMaxNode(root.left).right = root.right;
                    root.left = null;
                    root.right = null;
                    return result;
                } else if (root.left != null) {
                    TreeNode result = root.left;
                    root.left = null;
                    return result;
                } else if (root.right != null) {
                    TreeNode result = root.right;
                    root.right = null;
                    return result;
                } else {
                    return null;
                }
            } else {
                // 删除的节点不是 root 节点
                // 被删除的节点是否是父节点的左节点
                boolean toDeleteNodeIsLeftChild = toDeleteNodeParent.left == toDeleteNode;
                TreeNode left = toDeleteNode.left;
                TreeNode right = toDeleteNode.right;
                if (left == null && right == null) {
                    if (toDeleteNodeIsLeftChild) {
                        toDeleteNodeParent.left = null;
                    } else {
                        toDeleteNodeParent.right = null;
                    }
                } else if (right == null) {
                    if (toDeleteNodeIsLeftChild) {
                        toDeleteNodeParent.left = left;
                    } else {
                        toDeleteNodeParent.right = left;
                    }
                } else if (left == null) {
                    if (toDeleteNodeIsLeftChild) {
                        toDeleteNodeParent.left = right;
                    } else {
                        toDeleteNodeParent.right = right;
                    }
                } else {
                    TreeNode max = findMaxNode(left);
                    max.right = right;
                    if (toDeleteNodeIsLeftChild) {
                        toDeleteNodeParent.left = left;
                    } else {
                        toDeleteNodeParent.right = left;
                    }
                }

                return root;
            }
        } else {
            return root;
        }
    }

    /**
     * 0: 目标节点
     * 1: 目标节点的父节点
     */
    private TreeNode[] findTargetNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return new TreeNode[] { root, null };
        }
        if (root.left != null && root.left.val == key) {
            return new TreeNode[] { root.left, root };
        }
        if (root.right != null && root.right.val == key) {
            return new TreeNode[] { root.right, root };
        }
        if (key < root.val) {
            return findTargetNode(root.left, key);
        } else {
            return findTargetNode(root.right, key);
        }
    }

    private TreeNode findMaxNode(TreeNode root) {
        if (root.right == null) {
            return root;
        } else {
            return findMaxNode(root.right);
        }
    }

}
