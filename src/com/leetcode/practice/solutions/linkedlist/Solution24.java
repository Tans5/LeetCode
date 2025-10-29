package com.leetcode.practice.solutions.linkedlist;


import com.leetcode.practice.solutions.others.ListNode;

/**
 *
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class Solution24 {

    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode();
        ListNode resultCursor = result;
        ListNode cursor = head;
        while (cursor != null && cursor.next != null) {
            ListNode a = cursor;
            ListNode b = cursor.next;
            cursor = cursor.next.next;
            a.next = null;
            swapNeighbors(a, b);
            resultCursor.next = b;
            resultCursor = a;
        }
        if (cursor != null) {
            resultCursor.next = cursor;
        }
        return result.next;
    }

    public void swapNeighbors(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return;
        }
        ListNode bNext = b.next;
        b.next = a;
        a.next = bNext;
    }
}
