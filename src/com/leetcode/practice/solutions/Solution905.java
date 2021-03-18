package com.leetcode.practice.solutions;

public class Solution905 {

    public static int[] sortArrayByParity(int[] A) {
        int size = A.length;
        if (size < 2) {
            return A;
        }
        int temp;

        int focus = -1;
        for (int i = 0; i < size; i ++) {
            if (isSingle(A[i])) {
                focus = i;
                break;
            }
        }
        if (focus == -1 || focus == size - 1) {
            return A;
        }

        for (int i = 0; i < size && focus < size; i ++) {
            if (i > 0 && !isSingle(A[i]) && focus < i) {
                temp = A[i];
                A[i] = A[focus];
                A[focus] = temp;
                for (int j = focus; j < size; j ++) {
                    if (isSingle(A[j])) {
                        focus = j;
                        break;
                    }
                }
            }
        }
        return A;
    }

    public static boolean isSingle(int n) {
        return n % 2 == 1;
    }
}
