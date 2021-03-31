package com.leetcode.practice.solutions;

import java.util.Arrays;

public class Solution274 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int result = 0;
        int size = citations.length;
        int start = 0;
        int end = size;
        int mid;
        while (true) {
            mid = (start + end) / 2;
            if (citations[mid] >= size - mid) {
                if (result < size - mid) {
                    result = size - mid;
                }
                if (end != mid) {
                    end = mid;
                } else {
                    break;
                }
            } else {
                if (start != mid) {
                    start = mid;
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
