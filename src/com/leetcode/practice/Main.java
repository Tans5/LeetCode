package com.leetcode.practice;

import com.leetcode.practice.solutions.Solution475;
import com.leetcode.practice.solutions.Solution69;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // System.out.println(Solution475.findRadius(new int[] {1}, new int[] {1, 2, 3, 4}));

        int[] a = new int[] {1, 2, 3, 4};
        int[] b = new int[] {1, 4};
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println(Solution475.isCover(a, b, 1));
    }
}
