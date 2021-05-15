package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

public class SolutionOffer25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode();
        ListNode resultFocus = resultHead;
        ListNode l1Focus = l1;
        ListNode l2Focus = l2;
        while (l1Focus != null || l2Focus != null) {
            if (l1Focus == null || (l2Focus != null && l1Focus.val >= l2Focus.val)) {
                resultFocus.next = l2Focus;
                resultFocus = l2Focus;
                l2Focus = l2Focus.next;
                continue;
            }
            resultFocus.next = l1Focus;
            resultFocus = l1Focus;
            l1Focus = l1Focus.next;

        }
        return resultHead.next;
    }

}
