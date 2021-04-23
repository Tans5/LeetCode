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
            int[] na1 = slipNum(n1);
            int[] na2 = slipNum(n2);
            if (combineNum(na1, na2) > combineNum(na2, na1)) {
                return -1;
            } else {
                return 1;
            }
        });
        for (int num: nums2) {
            result.append(num);
        }

        return result.toString();
    }

    public static int[] slipNum(int n) {
        int size = ((Integer) n).toString().length();
        int[] result = new int[size];
        int nextSize = size;
        while (nextSize > 0) {
            int c = ((int) Math.pow(10, nextSize - 1));
            int num = n / c;
            n = n - num * c;
            result[size - nextSize] = num;
            nextSize --;
        }

        return result;
    }
    public static int combineNum(int[] start, int[] end) {
        int[] newArray = new int[start.length + end.length];
        System.arraycopy(start, 0, newArray, 0, start.length);
        System.arraycopy(end, 0, newArray, start.length, end.length);
        int result = 0;
        for (int i = 0; i < newArray.length; i ++) {
            result += newArray[i] * (int) Math.pow(10, newArray.length - i - 1);
        }
        return result;
    }
}
