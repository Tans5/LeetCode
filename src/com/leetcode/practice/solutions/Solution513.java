package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

public class Solution513 {

    public int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValueDeep(root, 1)[0];
    }

    public int[] findBottomLeftValueDeep(TreeNode root, int deep) {
        int[] result = new int[2];
        if (root.left == null && root.right == null) {
            result[0] = root.val;
            result[1] = deep;
            return result;
        }
        if (root.left == null) {
            return findBottomLeftValueDeep(root.right, deep + 1);
        }
        if (root.right == null) {
            return findBottomLeftValueDeep(root.left, deep + 1);
        }
        int[] resultLeft = findBottomLeftValueDeep(root.left, deep + 1);
        int[] resultRight = findBottomLeftValueDeep(root.right, deep + 1);
        if (resultLeft[1] < resultRight[1]) {
            return resultRight;
        } else {
            return resultLeft;
        }
    }

}
