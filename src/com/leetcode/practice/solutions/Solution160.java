package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode focusA = headA;
        boolean nodeAHasRouteToB = false;
        ListNode focusB = headB;
        boolean nodeBHasRouteToA = false;
        while (true) {
            if (focusA == null) {
                if (!nodeAHasRouteToB) {
                    nodeAHasRouteToB = true;
                    focusA = headB;
                } else {
                    return null;
                }
            }
            if (focusB == null) {
                if (!nodeBHasRouteToA) {
                    nodeBHasRouteToA = true;
                    focusB = headA;
                } else {
                    return null;
                }
            }
            if (focusA == focusB) {
                return focusA;
            }
            focusA = focusA.next;
            focusB = focusB.next;
        }
    }
}
