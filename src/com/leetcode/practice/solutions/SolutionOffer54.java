package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

public class SolutionOffer54 {

    public static int kthLargest(TreeNode root, int k) {
        routeK = 0;
        return kthLargestMe(root, k);
    }

    static int routeK = 0;

    public static Integer kthLargestMe(TreeNode root, int targetK) {
        if (root == null) {
            return null;
        }
        Integer result = kthLargestMe(root.right, targetK);
        if (result != null) {
            return result;
        }
        routeK ++;
        if (routeK == targetK) {
            return root.val;
        }
        return kthLargestMe(root.left, targetK);
    }

}
