package com.leetcode.practice;

import com.leetcode.practice.solutions.array.Solution3479;
import com.leetcode.practice.solutions.linkedlist.SolutionLRC26;
import com.leetcode.practice.solutions.others.ListNode;


public class Main {
    public static void main(String[] args) {
        SolutionLRC26 s = new SolutionLRC26();
        ListNode root = ListNode.createNode(new int[] { 1, 2, 3, 4, 5});
        s.reorderList(root);
        ListNode.printNode(root);
    }
}
