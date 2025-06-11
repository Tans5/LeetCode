package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 */
public class Solution230 {

    public int kthSmallest(TreeNode root, int k) {
        return smallest(root, k, new AtomicInteger(0));
    }


    private Integer smallest(TreeNode root, int k, AtomicInteger i) {
        if (root == null) {
            return null;
        }
        List<TreeNode> routeToMin = new ArrayList<>();
        routeToMinNode(root, routeToMin);
        while (!routeToMin.isEmpty()) {
            TreeNode parent = routeToMin.get(routeToMin.size() - 1);
            routeToMin.remove(routeToMin.size() - 1);
            i.addAndGet(1);
            if (k == i.intValue()) {
                return parent.val;
            } else {
                Integer r = smallest(parent.right, k, i);
                if (r != null) {
                    return r;
                }
            }
        }
        return null;
    }

    private void routeToMinNode(TreeNode root, List<TreeNode> route) {
        if (root == null) {
            return;
        }
        route.add(root);
        routeToMinNode(root.left, route);
    }
}
