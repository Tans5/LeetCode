package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        int indexOfRootInorder = -1;
        for (int i = 0; i < inorder.length; i ++) {
            if (inorder[i] == preorder[0]) {
                indexOfRootInorder = i;
                break;
            }
        }
        int[] inorderLeft = new int[indexOfRootInorder];
        int[] inorderRight = new int[inorder.length - indexOfRootInorder - 1];

        int[] preorderLeft = new int[indexOfRootInorder];
        int[] preorderRight = new int[inorder.length - indexOfRootInorder - 1];

        if (inorderLeft.length > 0) {
            System.arraycopy(inorder, 0, inorderLeft, 0, inorderLeft.length);
            System.arraycopy(preorder, 1, preorderLeft, 0, inorderLeft.length);
        }
        if (inorderRight.length > 0) {
            System.arraycopy(inorder, indexOfRootInorder + 1, inorderRight, 0, inorderRight.length);
            System.arraycopy(preorder, inorderLeft.length + 1, preorderRight, 0, inorderRight.length);
        }
        buildTreeInner(preorderLeft, inorderLeft, true, root);
        buildTreeInner(preorderRight, inorderRight, false, root);
        return root;
    }

    public void buildTreeInner(int[] preorder, int[] inorder, boolean isLeft, TreeNode tree) {
        if (inorder.length == 0 || preorder.length != inorder.length) {
            return;
        }
        TreeNode me = new TreeNode(preorder[0]);
        if (isLeft) {
            tree.left = me;
        } else {
            tree.right = me;
        }
        int indexOfRootInorder = -1;
        for (int i = 0; i < inorder.length; i ++) {
            if (inorder[i] == preorder[0]) {
                indexOfRootInorder = i;
                break;
            }
        }
        int[] inorderLeft = new int[indexOfRootInorder];
        int[] inorderRight = new int[inorder.length - indexOfRootInorder - 1];

        int[] preorderLeft = new int[indexOfRootInorder];
        int[] preorderRight = new int[inorder.length - indexOfRootInorder - 1];

        if (inorderLeft.length > 0) {
            System.arraycopy(inorder, 0, inorderLeft, 0, inorderLeft.length);
            System.arraycopy(preorder, 1, preorderLeft, 0, inorderLeft.length);
        }
        if (inorderRight.length > 0) {
            System.arraycopy(inorder, indexOfRootInorder + 1, inorderRight, 0, inorderRight.length);
            System.arraycopy(preorder, inorderLeft.length + 1, preorderRight, 0, inorderRight.length);
        }
        buildTreeInner(preorderLeft, inorderLeft, true, me);
        buildTreeInner(preorderRight, inorderRight, false, me);
    }
}
