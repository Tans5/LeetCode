package com.leetcode.practice.solutions;

import java.util.Arrays;

public class Solution16_06 {

//    public static int smallestDifference(int[] a, int[] b) {
//        if (a.length <= 0 || b.length <= 0) {
//            return -1;
//        }
//        Arrays.sort(a);
//        Arrays.sort(b);
//        int result = Integer.MAX_VALUE;
//        for (int j : a) {
//            int d = findClosestDistance(b, j);
//            if (d < result) {
//                result = d;
//            }
//        }
//        return result;
//    }
//    public static int findClosestDistance(int[] a, int target) {
//        int start = 0;
//        int end = a.length;
//        int distance;
//        while (true) {
//            int mid = (start + end) / 2;
//            if (a[mid] == target) {
//                distance = 0;
//                break;
//            }
//            if (a[mid] > target) {
//                if (end == mid) {
//                    distance = Math.min(twoNumsDistance(a[start], target), twoNumsDistance(a[Math.min(end, a.length - 1)], target));
//                    break;
//                } else {
//                    end = mid;
//                }
//            }
//            if (a[mid] < target) {
//                if (start == mid) {
//                    distance = Math.min(twoNumsDistance(a[start], target), twoNumsDistance(a[Math.min(end, a.length - 1)], target));
//                    break;
//                } else {
//                    start = mid;
//                }
//            }
//
//        }
//        return distance;
//
//    }
//
    public static int twoNumsDistance(int a, int b) {
        if (a >= 0 && b <= 0 && (b == Integer.MIN_VALUE || Integer.MAX_VALUE - a < - b)) {
            return Integer.MAX_VALUE;
        }
        if (a <= 0 && b >= 0 && (a == Integer.MIN_VALUE || Integer.MAX_VALUE - b < - a)) {
            return Integer.MAX_VALUE;
        }
        return Math.abs(a - b);
    }

    public static int smallestDifference(int[] a, int[] b) {
        if (a.length <= 0 || b.length <= 0) {
            return -1;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int result = Integer.MAX_VALUE;
        int ai = 0;
        int bi = 0;
        while (ai < a.length && bi < b.length) {
            int d = twoNumsDistance(a[ai], b[bi]);
            if (d < result) {
                result = d;
                if (d == 0) {
                    break;
                }
            }
            if (a[ai] > b[bi]) {
                bi ++;
            } else {
                ai ++;
            }
        }
        return result;
    }

}
