package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution235_2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> routeP = new ArrayList<>();
        List<TreeNode> routeQ = new ArrayList<>();
        findTargetNode(root, p, routeP);
        findTargetNode(root, q, routeQ);
        int size = Math.min(routeP.size(), routeQ.size());
        for (int i = size - 1; i >= 0; i --) {
            if (routeP.get(i).val == routeQ.get(i).val) {
                return routeP.get(i);
            }
        }
        return root;
    }

    public void findTargetNode(TreeNode start, TreeNode target, List<TreeNode> route) {
        if (start == null || target == null) {
            return;
        }
        route.add(start);
        if (start.val == target.val) {
            return;
        }
        if (start.val > target.val) {
            findTargetNode(start.left, target, route);
        } else {
            findTargetNode(start.right, target, route);
        }
    }
}
