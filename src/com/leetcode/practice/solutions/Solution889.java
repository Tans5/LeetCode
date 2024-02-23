package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution889 {


    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder.length == 0 || postorder.length == 0 || preorder.length != postorder.length) {
            return null;
        }
        Map<Integer, Integer> preorderValueToIndex = new HashMap<>();
        for (int i = 0; i < preorder.length; i ++) {
            preorderValueToIndex.put(preorder[i], i);
            if (i < preorder.length / 2) {
                int temp = postorder[i];
                postorder[i] = postorder[preorder.length - i - 1];
                postorder[preorder.length - i - 1] = temp;
            }
        }
        return buildTree(
                preorder,
                postorder,
                preorderValueToIndex,
                0,
                0,
                preorder.length
        );
    }


    // preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]  [1,3,7,6,2,5,4]
    public TreeNode buildTree(
            int[] preorder,
            int[] revertPostorder,
            Map<Integer, Integer> preorderValueToIndex,
            int preorderStartIndex,
            int revertPostorderStartIndex,
            int size
    ) {
        if (size == 0) {
            return null;
        }
        int currentNum = preorder[preorderStartIndex];
        TreeNode node = new TreeNode(currentNum);
        int nextRevertIndex = revertPostorderStartIndex + 1;
        if (nextRevertIndex < revertPostorderStartIndex + size) {
            int nextRightTreeNum = revertPostorder[nextRevertIndex];
            int nextRightTreeIndexInPreorder = preorderValueToIndex.get(nextRightTreeNum);

            int rightPreorderStartIndex = nextRightTreeIndexInPreorder;
            int rightTreeSize = preorderStartIndex + size - rightPreorderStartIndex;
            int rightRevertStartIndex = revertPostorderStartIndex + 1;
            node.right = buildTree(preorder, revertPostorder, preorderValueToIndex,
                    rightPreorderStartIndex, rightRevertStartIndex, rightTreeSize);

            int leftTreeSize = size  - rightTreeSize - 1;
            int leftPreorderStartIndex = nextRightTreeIndexInPreorder - leftTreeSize;
            int leftRevertStartIndex = rightRevertStartIndex + rightTreeSize;
            node.left = buildTree(preorder, revertPostorder, preorderValueToIndex, leftPreorderStartIndex,
                    leftRevertStartIndex, leftTreeSize);
        } else {
            int leftTreeSize = size - 1;
            int leftPreorderStartIndex = preorderStartIndex + 1;
            int leftRevertStartIndex = revertPostorderStartIndex - leftTreeSize;
            node.left = buildTree(preorder, revertPostorder, preorderValueToIndex, leftPreorderStartIndex, leftRevertStartIndex, leftTreeSize);
        }
        return node;
    }
}
