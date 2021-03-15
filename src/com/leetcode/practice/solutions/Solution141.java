package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode focusStep1 = head;
        ListNode focusStep2 = head;
        boolean hasCycle = false;
        while (true) {
            if (focusStep1 == null || focusStep2 == null || focusStep2.next == null || focusStep1.next == null) {
                break;
            }
            focusStep1 = focusStep1.next;
            focusStep2 = focusStep2.next.next;
            if (focusStep2 == focusStep1) {
                hasCycle = true;
                break;
            }

        }
        return hasCycle;
    }
}
