package com.leetcode.practice.solutions;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1027 {

    public static int longestArithSeqLength(int[] A) {
//        int size = A.length;
//        int maxLen = 2;
//        int len;
//        for (int i = 0; i < size - 2; i ++) {
//            for (int j = i + 1; j < size - 1; j ++) {
//                int diff = A[j] - A[i];
//                int focus = A[j];
//                len = 2;
//                for (int k = j + 1; k < size; k ++) {
//                    if (A[k] - focus == diff) {
//                        focus = A[k];
//                        len ++;
//                    }
//                }
//                if (len > maxLen) {
//                    maxLen = len;
//                }
//            }
//        }
//        return maxLen;

        int maxLen = 2;
        List<Map<Integer, Integer>> dp = new ArrayList<>();
        int size = A.length;
        for (int i = 0; i < size; i ++) {
            dp.add(new HashMap<>());
            for (int j = i - 1; j >= 0; j --) {
                int diff = A[i] - A[j];
                int len;
                if (dp.get(j) != null && dp.get(j).get(diff) != null) {
                    len = dp.get(j).get(diff) + 1;
                } else {
                    len = 2;
                }
                if (dp.get(i).get(diff) == null) {
                    dp.get(i).put(diff, len);
                } else {
                    dp.get(i).put(diff, Math.max(len, dp.get(i).get(diff)));
                }
                if (len > maxLen) {
                    maxLen = len;
                }
            }
        }
        return maxLen;
    }

}
