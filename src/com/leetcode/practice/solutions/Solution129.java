package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution129 {

    int mSum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        mSum = 0;
        List<Integer> route = new ArrayList<>();
        scanRoute(root, route);
        return mSum;
    }
    void scanRoute(TreeNode n, List<Integer> route) {
        if (n == null) {
            return;
        }
        route.add(n.val);
        if (n.left == null && n.right == null) {
            mSum += computeNumFromRoute(route);
        }
        scanRoute(n.left, route);
        scanRoute(n.right, route);

        route.remove(route.size() - 1);
    }

    int computeNumFromRoute(List<Integer> route) {
        int result = 0;
        int p = route.size() - 1;
        for (int i = 0; i < route.size(); i ++) {
            result += route.get(i) * (int) Math.pow(10, p);
            p --;
        }
        return result;
    }
}
