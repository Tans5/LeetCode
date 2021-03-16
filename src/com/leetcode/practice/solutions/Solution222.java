package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

public class Solution222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        FullResult leftResult = isFull(root.left);
        FullResult rightResult = isFull(root.right);
        int count = 1;
        if (leftResult.isFull) {
            count = count + (int) Math.pow(2, leftResult.deep) - 1;
            count = count + countNodes(root.right);
        } else {
            count = count + countNodes(root.left);
            count = count + (int) Math.pow(2, rightResult.deep) - 1;
        }
        return count;
    }

    class FullResult {
        public final int deep;
        public final boolean isFull;
        public FullResult(int deep, boolean isFull) {
            this.deep = deep;
            this.isFull = isFull;
        }
    }

    FullResult isFull(TreeNode root) {
        if (root == null) {
            return new FullResult(0, true);
        }
        int lDeep = 1;
        int rDeep = 1;
        TreeNode focus = root.left;
        while (true) {
            if (focus != null) {
                focus = focus.left;
                lDeep ++;
            } else {
                break;
            }
        }
        focus = root.right;
        while (true) {
            if (focus != null) {
                focus = focus.right;
                rDeep ++;
            } else {
                break;
            }
        }
        if (lDeep == rDeep) {
            return new FullResult(lDeep, true);
        } else {
            return new FullResult(lDeep, false);
        }
    }
}
