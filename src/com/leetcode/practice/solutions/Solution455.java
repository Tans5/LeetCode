package com.leetcode.practice.solutions;

import java.util.Arrays;

public class Solution455 {

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int si = 0;
        int gi = 0;
        int sSize = s.length;
        int gSize = g.length;
        while (si < sSize && gi < gSize) {
            if (g[gi] <= s[si]) {
                count ++;
                gi ++;
            }
            si ++;
        }
        return count;
    }
}
