package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;


/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 */
public class Solution235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            // 保证 p 的值小于 q 的值
            return lowestCommonAncestor(root, q, p);
        }
        TreeNode result = root;
        while (result != null) {
            if (result.val >= p.val && result.val <= q.val) {
                break;
            } else if (result.val < p.val) {
                result = result.right;
            } else {
                result = result.left;
            }
        }
        return result;
    }
}
