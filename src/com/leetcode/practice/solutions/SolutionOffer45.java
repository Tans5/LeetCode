package com.leetcode.practice.solutions;

import java.util.Arrays;

public class SolutionOffer45 {

    public static String minNumber(int[] nums) {
        StringBuilder result = new StringBuilder();
        Integer[] nums2 = new Integer[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            nums2[i] = nums[i];
        }
        Arrays.sort(nums2, (n1, n2) -> {
            if (n1.intValue() == n2.intValue()) {
                return 0;
            }
            if (compare(n1, n2)) {
                return 1;
            } else {
                return -1;
            }
        });
        for (int num: nums2) {
            result.append(num);
        }
        return result.toString();
    }

    public static boolean compare(int num1, int num2) {
        String s1 = num1 + "" + num2;
        String s2 = num2 + "" + num1;
        if (s1.length() > s2.length()) {
            return true;
        }
        if (s2.length() > s1.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int i = 0; i < chars1.length; i ++) {
            if (chars1[i] == chars2[i]) {
                continue;
            }
            if (chars1[i] > chars2[i]) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
