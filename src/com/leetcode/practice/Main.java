package com.leetcode.practice;

import com.leetcode.practice.solutions.dynamicprograming.Solution312;

public class Main {
    public static void main(String[] args) {
        Solution312 s = new Solution312();
        int coin = s.maxCoins(new int[] {3, 1, 5, 8});
        System.out.println(coin);
    }
}
