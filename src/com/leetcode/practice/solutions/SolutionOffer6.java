package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

public class SolutionOffer6 {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode focus = head;
        int size = 0;
        while (focus != null) {
            size ++;
            focus = focus.next;
        }
        int[] result = new int[size];
        focus = head;
        for (int i = size - 1; i >= 0; i --) {
            result[i] = focus.val;
            focus = focus.next;
        }
        return result;
    }

}
