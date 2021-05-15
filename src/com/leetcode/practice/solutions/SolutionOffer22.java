package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

public class SolutionOffer22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode focusK = head;
        int count = 0;
        while (count < k - 1) {
            focusK = focusK.next;
            count ++;
        }
        ListNode focus = head;
        while (focusK.next != null) {
            focusK = focusK.next;
            focus = focus.next;
        }
        return focusK;
    }

}
