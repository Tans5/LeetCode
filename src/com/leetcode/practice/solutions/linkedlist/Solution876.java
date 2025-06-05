package com.leetcode.practice.solutions.linkedlist;

import com.leetcode.practice.solutions.others.ListNode;

/**
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class Solution876 {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slowCursor = head;
        ListNode fastCursor = head;
        while (fastCursor != null && fastCursor.next != null) {
            slowCursor = slowCursor.next;
            fastCursor = fastCursor.next.next;
        }
        return slowCursor;
    }
}
