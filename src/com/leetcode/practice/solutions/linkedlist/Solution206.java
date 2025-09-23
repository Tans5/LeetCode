package com.leetcode.practice.solutions.linkedlist;

import com.leetcode.practice.solutions.others.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class Solution206 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previous = null;
        ListNode cursor = head;
        ListNode temp;
        while (cursor != null) {
            temp = cursor;
            cursor = cursor.next;
            temp.next = previous;
            previous = temp;
        }
        return previous;
    }
}
