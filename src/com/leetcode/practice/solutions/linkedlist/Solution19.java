package com.leetcode.practice.solutions.linkedlist;

import com.leetcode.practice.solutions.others.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        ListNode fastCursor = head;
        // 先让快指针先走 n.
        for (int i = 0; i < n; i ++) {
            if (fastCursor == null) {
                return head;
            } else {
                fastCursor = fastCursor.next;
            }
        }

        // 再让慢指针和快指针一起走，cursor 就是需要删除的节点
        ListNode previous = null;
        ListNode cursor = head;
        while (fastCursor != null) {
            previous = cursor;
            cursor = cursor.next;
            fastCursor = fastCursor.next;
        }
        if (previous == null) {
            // 删除的节点是头节点
            ListNode temp = head.next;
            head.next = null;
            return temp;
        } else {
            // 删除的节点不是头节点
            previous.next = cursor.next;
            cursor.next = null;
            return head;
        }
    }
}
