package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution234 {

    public boolean isPalindrome(ListNode head) {
        List<Integer> route = new ArrayList<>();
        ListNode n = head;
        while (n != null) {
            route.add(n.val);
            n = n.next;
        }
        if (route.isEmpty()) {
            return false;
        }
        for (int i = 0; i < (route.size() / 2); i ++) {
            int a = route.get(i);
            int b = route.get(route.size() - i - 1);
            if (a != b) {
                return false;
            }
        }
        return true;
    }
}
