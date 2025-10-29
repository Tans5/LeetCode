package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class Solution236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归基：如果遇到null，或者直接遇到p或q，则返回
        if (root == null || root == p || root == q) {
            return root;
        }

        // 在左子树中寻找p或q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 在右子树中寻找p或q
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 后序遍历逻辑
        if (left == null) {
            // 左子树没有，那么LCA在右子树返回的结果里
            return right;
        }
        if (right == null) {
            // 右子树没有，那么LCA在左子树返回的结果里
            return left;
        }
        // 如果left和right都不为空，说明p和q分别在当前节点的两侧，当前节点就是LCA
        return root;
    }
}
