package com.leetcode.practice.solutions.linkedlist;

import com.leetcode.practice.solutions.others.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode resultCursor = null;
        ListNode cursorA = l1;
        ListNode cursorB = l2;
        int nextPlus = 0;
        while (cursorA != null || cursorB != null) {
            int a = cursorA != null ? cursorA.val : 0;
            int b = cursorB != null ? cursorB.val : 0;
            cursorA = cursorA != null ? cursorA.next : null;
            cursorB = cursorB != null ? cursorB.next : null;
            int n = a + b + nextPlus;
            if (n >= 10) {
                nextPlus = 1;
                n = n % 10;
            } else {
                nextPlus = 0;
            }
            ListNode node = createNode(n);
            if (result == null) {
                result = node;
                resultCursor = node;
            } else {
                resultCursor.next = node;
                resultCursor = node;
            }
        }
        if (nextPlus != 0) {
            ListNode node = createNode(nextPlus);
            resultCursor.next = node;
            resultCursor = node;
        }
        return result;
    }

    private ListNode createNode(int v) {
        ListNode n = new ListNode();
        n.val = v;
        return n;
    }
}
