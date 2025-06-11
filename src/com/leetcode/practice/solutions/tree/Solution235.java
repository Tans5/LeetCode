package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

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
        Deque<TreeNode> routeToP = null;
        Deque<TreeNode> routeToQ = null;
        TreeNode cursor = root;
        Deque<TreeNode> route = new ArrayDeque<>();
        while ((routeToP == null || routeToQ == null) && (cursor != null || !route.isEmpty())) {
            if (cursor != null) {
                TreeNode n = cursor;
                while (n != null) {
                    route.push(n);
                    n = n.left;
                }
            }
            TreeNode n = route.pop();
            if (routeToP == null && n.val == p.val) {
                // FixMe:
                routeToP = new ArrayDeque<>(route);
            }
            if (routeToQ == null && n.val == q.val) {
                // FixMe:
                routeToQ = new ArrayDeque<>(route);
            }
            cursor = n.right;
        }
        if (routeToP == null || routeToQ == null) {
            return null;
        }
        TreeNode prev = root;
        while (!routeToP.isEmpty() && !routeToQ.isEmpty()) {
            TreeNode n1 = routeToP.poll();
            TreeNode n2 = routeToQ.poll();
            if (n1.val != n2.val) {
                break;
            } else {
                prev = n1;
            }
        }
        return prev;
    }
}
