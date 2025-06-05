package com.leetcode.practice;

import com.leetcode.practice.solutions.linkedlist.Solution92;
import com.leetcode.practice.solutions.others.ListNode;

public class Main {
    public static void main(String[] args) {
        Solution92 s = new Solution92();
        ListNode root = ListNode.createNode(new int[]{1, 2, 3, 4, 5});
        ListNode result = s.reverseBetween(root, 2, 4);
        ListNode.printNode(result);

    }
}
