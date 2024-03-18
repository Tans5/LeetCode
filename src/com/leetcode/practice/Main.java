package com.leetcode.practice;


import com.leetcode.practice.solutions.*;
import com.leetcode.practice.solutions.others.ListNode;


public class Main {
    public static void main(String[] args) {
        Solution82 s = new Solution82();

        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2, n3);
        ListNode n5 = new ListNode(1, n4);
        ListNode n = s.deleteDuplicates(n5);
        System.out.println(n);
    }
}
