package com.leetcode.practice.solutions;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int targetIndex;
//        int lastTargetIndex = 0;
//        for (int i = 0; i < n; i ++) {
//            targetIndex = -1;
//            for (int j = lastTargetIndex; j < m + i; j ++) {
//                if (nums2[i] < nums1[j]) {
//                    targetIndex = j;
//                    lastTargetIndex = j;
//                    break;
//                }
//            }
//            if (targetIndex == -1) {
//                for (int j = m + i, k = i; j < m + n; j ++, k ++) {
//                    nums1[j] = nums2[k];
//                }
//                break;
//            } else {
//                for (int j = m + i; j > targetIndex ; j --) {
//                    nums1[j] = nums1[j - 1];
//                }
//                nums1[targetIndex] = nums2[i];
//            }
//        }
        Deque<Integer> queue1 = new ArrayDeque<>();
        Deque<Integer> queue2 = new ArrayDeque<>();
        for (int i = 0; i < m; i ++) {
            queue1.offer(nums1[i]);
        }
        for (int i = 0; i < n; i ++) {
            queue2.offer(nums2[i]);
        }
        for (int i = 0; i < m + n; i ++) {
            int num;
            if (queue1.isEmpty() && queue2.isEmpty()) {
                break;
            }
            if (queue1.isEmpty()) {
                num = queue2.poll();
            } else if (queue2.isEmpty()) {
                num = queue1.poll();
            } else if (queue1.peek() < queue2.peek()) {
                num = queue1.poll();
            } else {
                num = queue2.poll();
            }
            nums1[i] = num;
        }
    }

}
