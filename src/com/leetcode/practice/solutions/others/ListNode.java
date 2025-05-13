package com.leetcode.practice.solutions.others;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createNode(int[] values) {
        if (values.length == 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode tail = head;
        for (int i = 1; i < values.length; i ++) {
            tail.next = new ListNode(values[i]);
            tail = tail.next;
        }
        return head;
    }

    public static void printNode(ListNode root) {
        if (root == null) {
            return;
        }
        StringBuilder str = new StringBuilder();
        ListNode p = null;
        ListNode c = root;
        do {
            if (p != null) {
                str.append(" -> ");
            }
            str.append(c.val);
            p = c;
            c = c.next;
        } while(c != null);
        System.out.println(str);
    }
}
