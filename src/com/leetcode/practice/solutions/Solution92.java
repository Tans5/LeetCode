package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

public class Solution92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left >= right) {
            return head;
        }
        ListNode startPre = null;
        ListNode start = null;
        ListNode end = null;
        ListNode endNext = null;

        ListNode pre = null;
        ListNode current = head;
        int index = 1;
        while (current != null) {
            if (index == left) {
                startPre = pre;
                start = current;
            }
            if (index == right) {
                end = current;
                endNext = end.next;
                break;
            }
            index ++;
            pre = current;
            current = pre.next;
        }
        if (start == end || start == null) {
            return head;
        }
        if (end != null) {
            end.next = null;
        }
        pre = null;
        current = start;
        ListNode next = start.next;
        while (current != null) {
            current.next = pre;
            pre = current;
            current = next;
            if (current != null) {
                next = current.next;
            } else {
                next = null;
            }
        }
        if (startPre == null) {
            head.next = endNext;
            return pre;
        } else {
            startPre.next = pre;
            start.next = endNext;
            return head;
        }
    }

}
