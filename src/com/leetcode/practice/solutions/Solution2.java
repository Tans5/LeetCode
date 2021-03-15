package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode resultHead = new ListNode();
        ListNode resultFocus = resultHead;
        ListNode focus1 = l1;
        ListNode focus2 = l2;
        boolean needUp = false;
        while (focus1 != null || focus2 != null || needUp) {
            int value = (focus1 == null ? 0 : focus1.val) + (focus2 == null ? 0 : focus2.val);
            if (needUp) {
                value++;
            }
            if (value < 10) {
                resultFocus.next = new ListNode(value);
                resultFocus = resultFocus.next;
                needUp = false;
            } else {
                resultFocus.next = new ListNode(value % 10);
                resultFocus = resultFocus.next;
                needUp = true;
            }
            if (focus1 != null) {
                focus1 = focus1.next;
            }
            if (focus2 != null) {
                focus2 = focus2.next;
            }
        }
        return resultHead.next;
    }
}
