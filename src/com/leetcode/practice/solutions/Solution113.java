package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> routes = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        scanTree(root, routes, 0, targetSum, result);
        return result;
    }

    public void scanTree(
            TreeNode tree,
            List<Integer> routes,
            int routeSum,
            int targetSum,
            List<List<Integer>> result) {
        if (tree == null) {
            return;
        }
        routeSum += tree.val;
        routes.add(tree.val);
        if (routeSum == targetSum && tree.left == null && tree.right == null) {
            result.add(new ArrayList<>(routes));
        }
        scanTree(tree.left, routes, routeSum, targetSum, result);
        scanTree(tree.right, routes, routeSum, targetSum, result);
        routes.remove(routes.size() - 1);
    }
}
