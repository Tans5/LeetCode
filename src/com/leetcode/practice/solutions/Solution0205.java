package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

public class Solution0205 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode focus = result;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int val = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) / 10;
            ListNode newNode = new ListNode(val);
            focus.next = newNode;
            focus = newNode;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry == 1) {
            focus.next = new ListNode(1);
        }
        return result.next;
    }

}
