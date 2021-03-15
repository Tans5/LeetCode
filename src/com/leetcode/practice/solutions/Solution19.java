package com.leetcode.practice.solutions;


import com.leetcode.practice.solutions.others.ListNode;

public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode rHead = new ListNode(-1, head);
        ListNode focusNode = rHead;
        int count = 0;
        while (true) {
            if (focusNode.next == null) {
                break;
            } else {
                count ++;
                focusNode = focusNode.next;
            }
        }
        int focusIndex = count - n;
        if (focusIndex < 0) {
            return null;
        }
        focusNode = rHead;
        for (int i = 0; i < focusIndex; i ++) {
            if (focusNode == null) {
                return null;
            }
            focusNode = focusNode.next;
        }
        focusNode.next = focusNode.next.next;
        return rHead.next;
    }
}
