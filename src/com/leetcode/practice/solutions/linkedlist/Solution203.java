package com.leetcode.practice.solutions.linkedlist;

import com.leetcode.practice.solutions.others.ListNode;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
class Solution203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode temp;
        while (head != null && head.val == val) {
            temp = head.next;
            head.next = null;
            head = temp;
        }
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previous = head;
        ListNode cursor = head.next;
        while (cursor != null) {
            if (cursor.val == val) {
                previous.next = cursor.next;
                cursor.next = null;
                cursor = previous.next;
            } else {
                previous = cursor;
                cursor = cursor.next;
            }
        }
        return head;
    }
}
