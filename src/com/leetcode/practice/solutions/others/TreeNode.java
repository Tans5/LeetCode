package com.leetcode.practice.solutions.others;

import java.util.Arrays;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void printTree(TreeNode tree) {
        if (tree == null) {
            return;
        }
        int treeHeight = treeHeight(tree);
        int lineSize = (int) (Math.pow(2, treeHeight - 1)) * 4;
        char [][] lines = new char[treeHeight][lineSize];
        for (char[] l: lines) {
            Arrays.fill(l, ' ');
        }
        buildTreeLines(tree, lines, 0, 1);
        for (char[] l: lines) {
            System.out.println(l);
        }
    }

    private static void buildTreeLines(TreeNode tree, char[][] lines, int lineWriteSize, int height) {
        if (tree == null) {
            return;
        }
        char[] line = lines[height - 1];
        int lineSize = line.length;
        int lineDataSize = 1 << (height - 1);
        int lineStep = lineSize / lineDataSize;
        printNumToLine(tree.val, lineStep * lineWriteSize + (lineStep - 2) / 2, line);
        int childLineWriteSize = lineWriteSize * 2;
        buildTreeLines(tree.left, lines, childLineWriteSize, height + 1);
        buildTreeLines(tree.right, lines, childLineWriteSize + 1, height + 1);
    }

    private static void printNumToLine(int value, int lineStartIndex, char[] line) {
        int n1 = value % 10;
        int n2 = value % 100 / 10;
        line[lineStartIndex] = (char) ('0' + n2);
        line[lineStartIndex + 1] = (char) ('0' + n1);
    }



    private static int treeHeight(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        return Math.max(treeHeight(tree.left), treeHeight(tree.right)) + 1;
    }

    public static TreeNode createTree(int[] preOrder, int[] midOrder) {
        if (preOrder.length != midOrder.length) {
            return null;
        }
        return createTree(preOrder, 0,
                midOrder, 0,
                midOrder.length);
    }

    private static TreeNode createTree(
            int[] preOrder, int preOrderStartIndex,
            int[] midOrder, int midOrderStartIndex,
            int size) {
        if (size <= 0) {
            return null;
        }
        if (preOrderStartIndex + size > preOrder.length) {
            return null;
        }
        if (midOrderStartIndex + size > midOrder.length) {
            return null;
        }
        int v = preOrder[preOrderStartIndex];
        TreeNode result = new TreeNode(v);
        int midOrderIndex = findTargetValueIndex(midOrder, midOrderStartIndex, size, v);
        if (midOrderIndex >= 0) {
            int leftChildNodeSize = midOrderIndex - midOrderStartIndex;
            int rightChildNodeSize = size - leftChildNodeSize - 1;
            result.left = createTree(preOrder, preOrderStartIndex + 1, midOrder, midOrderStartIndex, leftChildNodeSize);
            result.right = createTree(preOrder, preOrderStartIndex + 1 + leftChildNodeSize, midOrder, midOrderStartIndex + leftChildNodeSize + 1, rightChildNodeSize);
        }
        return result;
    }

    private static int findTargetValueIndex(int[] values, int startIndex, int size, int targetValue) {
        if (values.length < startIndex + size) {
            return -1;
        }
        for (int i = startIndex; i < startIndex + size; i ++) {
            if (values[i] == targetValue) {
                return i;
            }
        }
        return -1;
    }
}
