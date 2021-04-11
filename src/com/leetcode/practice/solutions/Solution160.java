package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<ListNode> routeA = new ArrayList<>();
        ListNode focusNode = headA;
        while (focusNode != null) {
            routeA.add(focusNode);
            focusNode = focusNode.next;
        }
        focusNode = headB;
        while (focusNode != null) {
            if (routeA.contains(focusNode)) {
                return focusNode;
            } else {
                focusNode = focusNode.next;
            }
        }
        return null;
    }
}
