package com.leetcode.practice;

import com.leetcode.practice.solutions.linkedlist.LRUCache;
import com.leetcode.practice.solutions.linkedlist.Solution2;
import com.leetcode.practice.solutions.linkedlist.Solution92;
import com.leetcode.practice.solutions.others.ListNode;
import com.leetcode.practice.solutions.others.TreeNode;
import com.leetcode.practice.solutions.tree.Solution105;
import com.leetcode.practice.solutions.tree.Solution108;

public class Main {
    public static void main(String[] args) {
        Solution108 s = new Solution108();
        TreeNode node = s.sortedArrayToBST(new int[] {1, 2, 3, 4, 5});
        TreeNode.printTree(node);
    }
}
