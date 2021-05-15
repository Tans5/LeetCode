package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

public class SolutionOffer24 {
    public ListNode reverseList(ListNode head) {
        ListNode result = head;
        ListNode pre = null;
        ListNode focus = head;
        while (focus != null) {
            result = focus;
            focus = focus.next;
            result.next = pre;
            pre = result;
        }
        return result;
    }
}
