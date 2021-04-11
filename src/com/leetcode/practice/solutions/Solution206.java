package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode focus = head;
        ListNode result;
        while (true) {
            ListNode next = focus.next;
            focus.next = pre;
            pre = focus;
            focus = next;
            if (focus.next == null) {
                focus.next = pre;
                result = focus;
                break;
            }
        }
        return result;
    }
}
