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
        if (root == null) {
            return null;
        }

        // 查找要删除的节点
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // 找到要删除的节点
            // 情况1: 只有一个子节点或没有子节点
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // 情况2: 有两个子节点
            // 找到右子树的最小节点
            TreeNode minNode = findMin(root.right);
            // 用最小节点的值替换当前节点的值
            root.val = minNode.val;
            // 删除右子树中的最小节点
            root.right = deleteNode(root.right, minNode.val);
        }

        return root;
    }

    // 找到子树中的最小节点（最左边的节点）
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}
