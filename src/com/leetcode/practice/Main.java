package com.leetcode.practice;


import com.leetcode.practice.solutions.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        int[] array = new int[] {1,0,-1,0,-2,2};
        List<List<Integer>> result = solution18.fourSum(array, 0);
        System.out.println("" + result);
    }
}
