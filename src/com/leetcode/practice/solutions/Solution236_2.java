package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution236_2 {

    List<TreeNode> routeP = null;
    List<TreeNode> routeQ = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        routeP = null;
        routeQ = null;
        routePAndQ(root, p, q, new ArrayList<>());
        if (routeP == null || routeQ == null) {
            return null;
        }
        int minRouteSize = Math.min(routeP.size(), routeQ.size());
        for (int i = 0; i < minRouteSize; i ++) {
            TreeNode current = routeP.get(i);
            TreeNode nextP = routeP.size() == i + 1 ? null : routeP.get(i + 1);
            TreeNode nextQ = routeQ.size() == i + 1 ? null : routeQ.get(i + 1);
            if (nextP == null || nextQ == null) {
                return current;
            }
            if (nextP.val != nextQ.val) {
                return current;
            }
        }

        return null;
    }

    void routePAndQ(TreeNode n, TreeNode p, TreeNode q, List<TreeNode> route) {
        if (n == null) {
            return;
        }
        route.add(n);
        if (routeP == null && n.val == p.val) {
            routeP = new ArrayList<>(route);
        }
        if (routeQ == null && n.val == q.val) {
            routeQ = new ArrayList<>(route);
        }
        if (routeP != null && routeQ != null) {
            return;
        }
        routePAndQ(n.left, p, q, route);
        routePAndQ(n.right, p, q, route);
        route.remove(route.size() - 1);
    }


}
