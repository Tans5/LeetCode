package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> route = new ArrayList<>();
        route.add(head);
        ListNode currentRoute = head;
        while (currentRoute.next != null) {
            currentRoute = currentRoute.next;
            if (route.contains(currentRoute)) {
                return currentRoute;
            } else {
                route.add(currentRoute);
            }
        }
        return null;
    }

}
