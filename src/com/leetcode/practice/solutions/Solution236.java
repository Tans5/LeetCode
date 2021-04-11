package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution236 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> routeP = new ArrayDeque<>();
        Deque<TreeNode> routeQ = new ArrayDeque<>();
        routeP.push(root);
        routeQ.push(root);
        routeTarget(root, p, routeP);
        routeTarget(root, q, routeQ);
        List<TreeNode> listP = new ArrayList<>(routeP);
        List<TreeNode> listQ = new ArrayList<>(routeQ);
        int indexP = listP.size() - 1;
        int indexQ = listQ.size() - 1;
        while (true) {
            if (indexP <= 0) {
                return listP.get(0);
            }
            if (indexQ <= 0) {
                return listQ.get(0);
            }
            if (listP.get(indexP - 1).val != listQ.get(indexQ - 1).val) {
                return listP.get(indexP);
            } else {
                indexP --;
                indexQ --;
            }
        }
    }

    public static boolean routeTarget(TreeNode root, TreeNode target, Deque<TreeNode> route) {
        if (root.val == target.val) {
            return true;
        } else {
            boolean result;
            if (root.left != null) {
                route.push(root.left);
                result = routeTarget(root.left, target, route);
                if (result) {
                    return true;
                } else {
                    route.pop();
                }
            }
            if (root.right != null) {
                route.push(root.right);
                result = routeTarget(root.right, target, route);
                if (result) {
                    return true;
                } else {
                    route.pop();
                }
            }
            return false;
        }
    }

}
