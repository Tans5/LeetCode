package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

public class Solution61_2 {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        ListNode focus = head;
        int size = 1;
        while (focus.next != null) {
            focus = focus.next;
            size ++;
        }
        k = k % size;
        focus.next = head;
        ListNode result;
        for (int i = 0; i < size - k; i ++) {
            focus = focus.next;
        }
        result = focus.next;
        focus.next = null;
        return result;
    }
}
