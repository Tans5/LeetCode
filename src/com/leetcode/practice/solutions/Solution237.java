package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

public class Solution237 {
    public void deleteNode(ListNode node) {
        ListNode focus = node;
        while (true) {
            if (focus == null || focus.next == null) {
                break;
            }
            if (focus.next.next == null) {
                focus.val = focus.next.val;
                focus.next = null;
                break;
            }
            focus.val = focus.next.val;
            focus = focus.next;
        }
    }
}
