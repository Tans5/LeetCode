package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

public class Solution83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode focus = head;
        while (true) {
            if (focus == null || focus.next == null) {
                break;
            } else {
                if (focus.val == focus.next.val) {
                    focus.next = focus.next.next;
                } else {
                    focus = focus.next;
                }
            }
        }
        return head;
    }

}
