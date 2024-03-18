package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

public class Solution206_2 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode current = head;
        ListNode next = head.next;
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
        return pre;
    }

}
